package com.emreyigit98.pharmacyapp.presentation.screen.city_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.emreyigit98.pharmacyapp.R
import com.emreyigit98.pharmacyapp.domain.model.city_model.CityModel
import com.emreyigit98.pharmacyapp.presentation.component.alert_dialog.PharmacyAlertDialog
import com.emreyigit98.pharmacyapp.presentation.component.error_screen.ErrorScreen
import com.emreyigit98.pharmacyapp.presentation.component.loading_screen.LoadingScreen

@Composable
fun CityScreen(
    modifier: Modifier = Modifier,
    cityScreenViewModel: CityScreenViewModel = hiltViewModel(),
    onNextScreen : (CityModel) -> Unit,
    navigationBack : () -> Unit,
    confirmButton : () -> Unit
) {
    val cityState = cityScreenViewModel.cityState.value
    Surface(
        modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.special_black)
    ) {
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            when {
                cityState.loading -> {
                    LoadingScreen()
                }
                cityState.error.isNotBlank() -> {
                    ErrorScreen(onClick = cityScreenViewModel::cityTryAgain)
                }
                else -> {
                    PharmacyAlertDialog(
                        items = cityState.responseCityList,
                        content = { cityModel ->
                            Row(
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, top = 2.dp, bottom = 2.dp)
                                    .clickable { onNextScreen(cityModel) },
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = cityModel.cities,
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        color = colorResource(id = R.color.white)
                                    ),
                                    modifier = modifier.padding(vertical = 10.dp)
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = null,
                                    tint = colorResource(id = R.color.white)
                                )
                            }
                        },
                        title = stringResource(id = R.string.city_dialog_title_one),
                        confirmButton = confirmButton,
                        onDismissRequest = navigationBack
                    )
                }
            }
        }
    }
}