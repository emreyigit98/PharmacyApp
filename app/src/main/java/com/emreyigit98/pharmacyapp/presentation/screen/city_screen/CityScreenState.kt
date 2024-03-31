package com.emreyigit98.pharmacyapp.presentation.screen.city_screen

import com.emreyigit98.pharmacyapp.domain.model.city_model.CityModel

data class CityScreenState(
    var error : String = "",
    var responseCityList : List<CityModel> = emptyList(),
    var loading : Boolean = false
)
