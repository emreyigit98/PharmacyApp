package com.emreyigit98.pharmacyapp.data.remote.api

import com.emreyigit98.pharmacyapp.data.remote.dto.city_dto.CityDto
import com.emreyigit98.pharmacyapp.data.remote.dto.district_dto.DistrictDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_detail_dto.PharmacyDetailDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_dto.PharmacyDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PharmacyApi {

    @GET("pharmacies-on-duty/cities")
    suspend fun allCityList(
        @Query("apiKey") apiKey : String
    ) : CityDto

    @GET("pharmacies-on-duty/cities")
    suspend fun allDistrictList(
        @Query("city") city : String , @Query("apiKey") apiKey: String
    ) : DistrictDto

    @GET("pharmacies-on-duty")
    suspend fun allPharmacyList(
        @Query("city") city: String , @Query("district") district : String , @Query("apiKey") apiKey: String
    ) : PharmacyDto

    @GET("pharmacies-on-duty")
    suspend fun allPharmacyDetail(
        @Query("detailsID") detailsId : Int , @Query("apiKey") apiKey: String
    ) : PharmacyDetailDto
}