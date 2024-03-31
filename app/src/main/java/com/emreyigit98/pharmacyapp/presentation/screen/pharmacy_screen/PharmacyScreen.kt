package com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.emreyigit98.pharmacyapp.R
import com.emreyigit98.pharmacyapp.domain.model.phamracy_model.PharmacyModel
import com.emreyigit98.pharmacyapp.presentation.component.button.PharmacyButton
import com.emreyigit98.pharmacyapp.presentation.component.error_screen.ErrorScreen
import com.emreyigit98.pharmacyapp.presentation.component.loading_screen.LoadingScreen

@Composable
fun PharmacyScreen(
    modifier: Modifier = Modifier,
    pharmacyScreenViewModel: PharmacyScreenViewModel = hiltViewModel(),
    onNextScreen: (PharmacyModel) -> Unit,
    tryOnClick : () -> Unit
) {
    val pharmacyState = pharmacyScreenViewModel.pharmacyState.value

    Surface(
        modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.special_black)
    ) {
        when {
            pharmacyState.loading -> {
                LoadingScreen()
            }
            pharmacyState.error.isNotBlank() -> {
                ErrorScreen(
                    onClick = pharmacyScreenViewModel::resetPharmacy
                )
            }
            else -> {
                if (pharmacyState.pharmacyList.isEmpty()) {
                    Column(
                        modifier = modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Column(
                            modifier = modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = stringResource(id = R.string.empty_list_title),
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    color = colorResource(id = R.color.white)
                                )
                            )
                            PharmacyButton(
                                text = stringResource(id = R.string.empty_list_try_again),
                                onClick = tryOnClick
                            )
                        }
                    }
                }else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(count = 2),
                        modifier = modifier.fillMaxSize(),
                        contentPadding = PaddingValues(all = 10.dp)
                    ) {
                        items(pharmacyState.pharmacyList) { pharmacyModel ->
                            PharmacyCard(
                                pharmacyModel = pharmacyModel,
                                onNextScreen = {
                                    onNextScreen(pharmacyModel)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PharmacyCard(
    pharmacyModel: PharmacyModel,
    modifier: Modifier = Modifier,
    onNextScreen : (PharmacyModel) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.special_black_olive)
        ),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.white)),
        modifier = modifier
            .padding(all = 5.dp)
            .height(220.dp)
    ) {
        Box(
            modifier = modifier
                .weight(1f)
                .clickable { onNextScreen(pharmacyModel) },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.splash_screen_logo),
                    contentDescription = null,
                    modifier = modifier.size(100.dp),
                    tint = colorResource(id = R.color.white)
                )
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${pharmacyModel.pharmacyName.substring(0,8)}...",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.white)
                        ),
                        modifier = modifier
                    )
                }
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = modifier.padding(end = 10.dp),
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}
/*
@Composable
fun G() {
    Text(
        text = "${pharmacyModel.pharmacyName.substring(0,8)}...",
        style = TextStyle(
            fontSize = 20.sp,
            color = colorResource(id = R.color.white)
        ),
        modifier = modifier
    )
    Icon(
        imageVector = Icons.Default.ArrowForward,
        contentDescription = null,
        modifier = modifier.padding(end = 10.dp),
        tint = colorResource(id = R.color.white)
    )
    Icon(
        painter = painterResource(id = R.drawable.splash_screen_logo),
        contentDescription = null,
        modifier = modifier.size(60.dp),
        tint = colorResource(id = R.color.white)
    )
}

 */