package com.emreyigit98.pharmacyapp.domain.repo

import com.emreyigit98.pharmacyapp.data.remote.dto.city_dto.CityDto
import com.emreyigit98.pharmacyapp.data.remote.dto.district_dto.DistrictDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_detail_dto.PharmacyDetailDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_dto.PharmacyDto

interface PharmacyRepository {

    suspend fun allCityList(apiKey : String) : CityDto

    suspend fun allDistrictList(city : String , apiKey: String) : DistrictDto

    suspend fun allPharmacyList(city: String , district : String , apiKey: String) : PharmacyDto

    suspend fun allPharmacyDetail(detailsId : Int , apiKey: String) : PharmacyDetailDto

}