package com.emreyigit98.pharmacyapp.data.remote.dto.city_dto

import com.google.gson.annotations.SerializedName

data class CityDto(
    val creditUsed: Int,
    @SerializedName("data")
    val cityList: List<Data>,
    val endpoint: String,
    val message: String,
    val messageTR: String,
    val rowCount: Int,
    val status: String,
    val systemTime: Int
)