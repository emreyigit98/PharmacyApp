package com.emreyigit98.pharmacyapp.presentation.navigation

import com.emreyigit98.pharmacyapp.R

object HomeScreenDestination : Screen {
    override val route: String
        get() = "onboarding_screen"
    override val argument: String
        get() = ""
    override val screenName: String
        get() = "Ana Sayfa"
}

object CityScreenDestination : Screen{
    override val route: String
        get() = "city_screen"
    override val argument: String
        get() = "city_argument"
    override val screenName: String
        get() = "Nöbetçi Eczaneler"
}

object DistrictScreenDestination : Screen{
    override val route: String
        get() = "district_screen"
    override val argument: String
        get() = "district_argument"
    override val screenName: String?
        get() = null
}

object PharmacyScreenDestination : Screen {
    override val route: String
        get() = "pharmacy_screen"
    override val argument: String
        get() = "city_argument"
    val argumentDistrict : String get() = "district_argument"
    override val screenName: String?
        get() = null
}

object PharmacyDetailScreenDestination : Screen {
    override val route: String
        get() = "pharmacy_detail_screen"
    override val argument: String
        get() = "pharmacy_id"
    override val screenName: String?
        get() = null
}

