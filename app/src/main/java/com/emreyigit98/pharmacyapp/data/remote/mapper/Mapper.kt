package com.emreyigit98.pharmacyapp.data.remote.mapper

import com.emreyigit98.pharmacyapp.data.remote.dto.city_dto.CityDto
import com.emreyigit98.pharmacyapp.data.remote.dto.district_dto.DistrictDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_detail_dto.PharmacyDetailDto
import com.emreyigit98.pharmacyapp.data.remote.dto.pharmacy_dto.PharmacyDto
import com.emreyigit98.pharmacyapp.domain.model.city_model.CityModel
import com.emreyigit98.pharmacyapp.domain.model.district_model.DistrictModel
import com.emreyigit98.pharmacyapp.domain.model.phamracy_model.PharmacyModel
import com.emreyigit98.pharmacyapp.domain.model.pharmacy_detail_model.PharmacyDetailModel

object Mapper {

    fun CityDto.toCityModel() : List<CityModel> {
        return cityList.map { data ->
            CityModel(data.cities,data.slug)
        }
    }
    fun DistrictDto.toDistrictModel() : List<DistrictModel> {
        return districtList.map { data ->
            DistrictModel(data.cities,data.slug)
        }
    }
    fun PharmacyDto.toPharmacyModel() : List<PharmacyModel> {
        return pharmacyList.map { data ->
            PharmacyModel(data.pharmacyID,data.pharmacyName)
        }
    }
    fun PharmacyDetailDto.toPharmacyDetailModel() : List<PharmacyDetailModel> {
        return pharmacyDetailList.map { data ->
            PharmacyDetailModel(
                address = data.address,
                city = data.city,
                district = data.district,
                pharmacyName = data.pharmacyName,
                phone = data.phone,
                latitude = data.latitude,
                longitude = data.longitude
            )
        }
    }
}

