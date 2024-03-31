package com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_detail_dto

import com.google.gson.annotations.SerializedName

data class PharmacyDetailDto(
    val creditUsed: Int,
    @SerializedName("data")
    val pharmacyDetailList: List<Data>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)