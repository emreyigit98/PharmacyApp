package com.emreyigit98.pharmacyapp.data.remote.dto.district_dto

import com.google.gson.annotations.SerializedName

data class DistrictDto(
    val creditUsed: Int,
    @SerializedName("data")
    val districtList: List<Data>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)