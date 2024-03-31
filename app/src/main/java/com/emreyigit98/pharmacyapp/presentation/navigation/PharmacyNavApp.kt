package com.emreyigit98.pharmacyapp.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emreyigit98.pharmacyapp.domain.model.pharmacy_detail_model.PharmacyDetailModel
import com.emreyigit98.pharmacyapp.presentation.component.drawer_menu.PharmacyDrawerMenu
import com.emreyigit98.pharmacyapp.presentation.component.top_app_bar.PharmacyTopAppBar
import com.emreyigit98.pharmacyapp.presentation.screen.city_screen.CityScreen
import com.emreyigit98.pharmacyapp.presentation.screen.district_screen.DistrictScreen
import com.emreyigit98.pharmacyapp.presentation.screen.home_screen.HomeScreen
import com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_detail_screen.PharmacyDetailScreen
import com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_screen.PharmacyScreen
import com.emreyigit98.pharmacyapp.util.ScreenListItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PharmacyNavApp(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    navHostController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    modifier: Modifier = Modifier,
    clickable : (PharmacyDetailModel) -> Unit
) {
    var cityArg by remember { mutableStateOf("") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            PharmacyDrawerMenu(
                screenList = ScreenListItem.screenList,
                selectNextScreen = {
                    navHostController.navigate(it) {
                        popUpTo(it) {
                            inclusive = true
                        }
                    }
                    coroutineScope.launch { drawerState.close() }
                }
            )
        },
        scrimColor = Color.Transparent
    ) {
        Scaffold(
            topBar = {
                PharmacyTopAppBar(
                    onClick = {
                        coroutineScope.launch { drawerState.open() }
                    }
                )
            }
        ) { paddingValues ->
            NavHost(
                navController = navHostController, startDestination = HomeScreenDestination.route,
                modifier = modifier.padding(paddingValues = paddingValues)
            ) {
                composable(HomeScreenDestination.route) {
                    HomeScreen(
                        onClick = { navHostController.navigate(CityScreenDestination.route) }
                    )
                }
                composable(CityScreenDestination.route) {
                    CityScreen(
                        onNextScreen = { cityModel ->
                            cityArg = cityModel.citySlug
                            navHostController.navigate(DistrictScreenDestination.route + "/${cityModel.citySlug}") {
                            }
                        },
                        navigationBack = {
                            navHostController.navigate(HomeScreenDestination.route) {
                                popUpTo(navHostController.graph.id) {
                                    saveState = true
                                }
                            }
                        },
                        confirmButton = {
                            navHostController.navigate(HomeScreenDestination.route) {
                                popUpTo(navHostController.graph.id) {
                                    saveState = true
                                }
                            }
                        }
                    )
                }
                composable(DistrictScreenDestination.route + "/{${DistrictScreenDestination.argument}}") {
                    DistrictScreen(
                        onNextScreen = { distrcitModel ->
                            navHostController.navigate(PharmacyScreenDestination.route + "/${cityArg}/${distrcitModel.citySlug}") {
                                popUpTo(navHostController.graph.id) {
                                    saveState = true
                                }
                            }
                        },
                        confirmButton = {
                            navHostController.navigate(HomeScreenDestination.route) {
                                popUpTo(navHostController.graph.id) {
                                    saveState = true
                                }
                            }
                        },
                        navigationBack = {
                            navHostController.navigate(HomeScreenDestination.route) {
                                popUpTo(navHostController.graph.id) {
                                    saveState = true
                                }
                            }
                        }
                    )
                }
                composable(PharmacyScreenDestination.route + "/{${PharmacyScreenDestination.argument}}/{${PharmacyScreenDestination.argumentDistrict}}") {
                    PharmacyScreen(
                        onNextScreen = { pharmacyModel ->
                            navHostController.navigate(PharmacyDetailScreenDestination.route+"/${pharmacyModel.pharmacyId}")
                        },
                        tryOnClick = { navHostController.navigate(CityScreenDestination.route) }
                    )
                }
                composable(PharmacyDetailScreenDestination.route + "/{${PharmacyDetailScreenDestination.argument}}") {
                    PharmacyDetailScreen(
                        clickable = { pharmacyDetailModel ->
                            clickable(pharmacyDetailModel)
                        }
                    )
                }
            }
        }
    }
}
