package com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_detail_screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.emreyigit98.pharmacyapp.R
import com.emreyigit98.pharmacyapp.domain.model.pharmacy_detail_model.PharmacyDetailModel
import com.emreyigit98.pharmacyapp.presentation.component.error_screen.ErrorScreen
import com.emreyigit98.pharmacyapp.presentation.component.loading_screen.LoadingScreen

@Composable
fun PharmacyDetailScreen(
    modifier: Modifier = Modifier,
    pharmacyDetailViewModel: PharmacyDetailViewModel = hiltViewModel(),
    clickable: (PharmacyDetailModel) -> Unit
) {
    val pharmacyDetailState = pharmacyDetailViewModel.pharmacyDetailState.value

    Surface(
        modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.special_black)
    ) {
        when {
            pharmacyDetailState.loading -> {
                LoadingScreen()
            }

            pharmacyDetailState.error.isNotBlank() -> {
                ErrorScreen(
                    onClick = pharmacyDetailViewModel::resetPharmacyDetail
                )
            }

            else -> {
                Column(
                    modifier = modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.08f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.pharmacy_detail),
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.white)
                        )
                    }
                    LazyColumn(
                        modifier = modifier.fillMaxSize()
                    ) {
                        items(pharmacyDetailState.pharmacyDetailList) { pharmacyDetailModel ->
                            PharmacyDetailCard(
                                pharmacyDetailModel = pharmacyDetailModel,
                                modifier = modifier,
                                clickable = {
                                    clickable(pharmacyDetailModel)
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
fun PharmacyDetailCard(
    pharmacyDetailModel: PharmacyDetailModel,
    modifier: Modifier,
    clickable: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.special_black_olive)
        ),
        elevation = CardDefaults.cardElevation(
            10.dp
        ),
        modifier = modifier.padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PharmacyText(
                title = stringResource(id = R.string.pharmacy),
                content = pharmacyDetailModel.pharmacyName
            )
            PharmacyText(
                title = stringResource(id = R.string.city),
                content = pharmacyDetailModel.city
            )
            PharmacyText(
                title = stringResource(id = R.string.distrcit),
                content = pharmacyDetailModel.district
            )
            PharmacyText(
                title = stringResource(id = R.string.address),
                content = pharmacyDetailModel.address
            )
            PharmacyText(
                title = stringResource(id = R.string.phone),
                content = pharmacyDetailModel.phone,
                icon = {
                    Icon(
                        imageVector = Icons.Default.Call, contentDescription = null,
                        tint = colorResource(id = R.color.white)
                    )
                },
                modifier = modifier.clickable { clickable() }
            )
        }
    }
}
@Composable
fun PharmacyText(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    icon: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
            )
            icon()
        }
        Text(
            text = content,
            style = TextStyle(
                fontSize = 20.sp,
                color = colorResource(id = R.color.white)
            )
        )
        HorizontalDivider(
            color = colorResource(id = R.color.white)
        )
    }
}

