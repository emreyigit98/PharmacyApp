package com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_dto

import com.google.gson.annotations.SerializedName

data class PharmacyDto(
    val creditUsed: Int,
    @SerializedName("data")
    val pharmacyList: List<Data>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)