package com.emreyigit98.pharmacyapp.domain.model.pharmacy_detail_model

data class PharmacyDetailModel(
    val pharmacyName : String,
    val address: String,
    val city : String,
    val district : String,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
)
