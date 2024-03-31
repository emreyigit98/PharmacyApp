package com.emreyigit98.pharmacyapp.presentation.component.loading_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.emreyigit98.pharmacyapp.R

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize(), color = colorResource(id = R.color.special_black)) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                color = colorResource(id = R.color.white)
            )
        }
    }
}