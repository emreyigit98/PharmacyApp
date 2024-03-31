package com.emreyigit98.pharmacyapp.presentation.component.error_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.emreyigit98.pharmacyapp.R
import com.emreyigit98.pharmacyapp.presentation.component.button.PharmacyButton

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    onClick : () -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.special_black)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.offline_icon),
                    contentDescription = null,
                    modifier = modifier.size(220.dp),
                    tint = colorResource(id = R.color.white)
                )
                PharmacyButton(
                    text = stringResource(id = R.string.try_again_button),
                    onClick = onClick
                )
            }
        }
    }
}


