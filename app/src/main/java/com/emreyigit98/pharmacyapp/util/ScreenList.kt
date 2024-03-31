package com.emreyigit98.pharmacyapp.util

import androidx.annotation.DrawableRes
import com.emreyigit98.pharmacyapp.R
import com.emreyigit98.pharmacyapp.presentation.navigation.CityScreenDestination
import com.emreyigit98.pharmacyapp.presentation.navigation.HomeScreenDestination

data class DrawerMenuItem(
    @DrawableRes val icon : Int,
    val route : String,
    val screenName : String
)
object ScreenListItem {
    val screenList : List<DrawerMenuItem> = listOf(
        DrawerMenuItem(
            icon = R.drawable.home_screen_logo, route = HomeScreenDestination.route, screenName = HomeScreenDestination.screenName
        ),
        DrawerMenuItem(
            icon = R.drawable.pharmacy_logo, route = CityScreenDestination.route, screenName = CityScreenDestination.screenName
        )
    )
}