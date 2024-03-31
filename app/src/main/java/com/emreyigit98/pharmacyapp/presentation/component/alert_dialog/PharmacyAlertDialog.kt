package com.emreyigit98.pharmacyapp.presentation.component.alert_dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.emreyigit98.pharmacyapp.R

@Composable
fun <T> PharmacyAlertDialog(
    items: List<T>,
    content: @Composable (T) -> Unit,
    modifier: Modifier = Modifier,
    title: String,
    confirmButton: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.white)
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.city__con),
                contentDescription = null,
                modifier = modifier.size(26.dp),
                tint = colorResource(id = R.color.white)
            )
        },
        text = {
            LazyColumn(
                modifier = modifier.fillMaxWidth()
                    .fillMaxHeight(0.65f),
                verticalArrangement = Arrangement.Center,
            ) {
                items(items) {
                    content(it)
                }
            }
        },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(onClick = confirmButton) {
                Text(
                    text = stringResource(id = R.string.city_screen_dialog_close),
                    color = colorResource(id = R.color.white)
                )
            }
        },
        containerColor = colorResource(id = R.color.special_black_olive),
        modifier = modifier.padding(vertical = 10.dp)
    )
}
