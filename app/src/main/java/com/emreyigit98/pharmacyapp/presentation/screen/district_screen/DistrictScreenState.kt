package com.emreyigit98.pharmacyapp.presentation.screen.district_screen

import com.emreyigit98.pharmacyapp.domain.model.district_model.DistrictModel

data class DistrictScreenState(
    var districtList: List<DistrictModel> = emptyList(),
    var error : String = "",
    var loading : Boolean = false
)
