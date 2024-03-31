package com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_detail_screen

import com.emreyigit98.pharmacyapp.domain.model.pharmacy_detail_model.PharmacyDetailModel

data class PharmacyDetailState(
    var pharmacyDetailList: List<PharmacyDetailModel> = emptyList(),
    var loading : Boolean = false,
    var error : String = ""
)
