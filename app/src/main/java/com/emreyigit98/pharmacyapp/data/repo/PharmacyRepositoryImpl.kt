package com.emreyigit98.pharmacyapp.data.repo

import com.emreyigit98.pharmacyapp.data.remote.api.PharmacyApi
import com.emreyigit98.pharmacyapp.data.remote.dto.city_dto.CityDto
import com.emreyigit98.pharmacyapp.data.remote.dto.district_dto.DistrictDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_detail_dto.PharmacyDetailDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_dto.PharmacyDto
import com.emreyigit98.pharmacyapp.domain.repo.PharmacyRepository
import javax.inject.Inject

class PharmacyRepositoryImpl @Inject constructor(
    private val pharmacyApi: PharmacyApi
) : PharmacyRepository {

    override suspend fun allCityList(apiKey: String): CityDto {
        return pharmacyApi.allCityList(apiKey = apiKey)
    }

    override suspend fun allDistrictList(city: String, apiKey: String): DistrictDto {
        return pharmacyApi.allDistrictList(city = city, apiKey = apiKey)
    }

    override suspend fun allPharmacyList(
        city: String, district: String, apiKey: String
    ): PharmacyDto {
        return pharmacyApi.allPharmacyList(city = city, district = district, apiKey = apiKey)
    }

    override suspend fun allPharmacyDetail(detailsId: Int, apiKey: String): PharmacyDetailDto {
        return pharmacyApi.allPharmacyDetail(detailsId = detailsId, apiKey = apiKey)
    }
}