package com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_screen

import com.emreyigit98.pharmacyapp.domain.model.phamracy_model.PharmacyModel

data class PharmacyState(
    var pharmacyList: List<PharmacyModel> = emptyList(),
    var loading : Boolean = false,
    var error : String = ""
)
