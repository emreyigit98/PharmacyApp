package com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_detail_dto

data class Data(
    val address: String,
    val city: String,
    val directions: Any,
    val district: String,
    val latitude: Double,
    val longitude: Double,
    val pharmacyDutyEnd: Any,
    val pharmacyDutyStart: Any,
    val pharmacyID: Int,
    val pharmacyName: String,
    val phone: String,
    val phone2: Any,
    val town: String
)