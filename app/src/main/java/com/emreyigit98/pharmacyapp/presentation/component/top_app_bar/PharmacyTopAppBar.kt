package com.emreyigit98.pharmacyapp.presentation.component.top_app_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.emreyigit98.pharmacyapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmacyTopAppBar(
    onClick : () -> Unit
) {
    TopAppBar(
        title = {
             Text(
                 text = stringResource(id = R.string.top_app_bar_name),
                 color = colorResource(id = R.color.white)
             )
        },
        navigationIcon = {
            IconButton(
                onClick = onClick,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = colorResource(id = R.color.white)
                )
            ) {
                Icon(imageVector = Icons.Outlined.Menu, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.special_black)
        )
    )
}
