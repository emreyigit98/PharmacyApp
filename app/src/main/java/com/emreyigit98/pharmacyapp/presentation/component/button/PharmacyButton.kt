package com.emreyigit98.pharmacyapp.presentation.component.button


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.emreyigit98.pharmacyapp.R

@Composable
fun PharmacyButton(
    modifier : Modifier = Modifier,
    text : String,
    onClick : () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(0.6f),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.special_black_olive)
        )
    ) {
        Text(
            text = text,
            color = colorResource(id = R.color.white)
        )
    }
}
