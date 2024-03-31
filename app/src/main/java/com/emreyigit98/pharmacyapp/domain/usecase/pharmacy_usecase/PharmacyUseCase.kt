package com.emreyigit98.pharmacyapp.domain.usecase.pharmacy_usecase

import com.emreyigit98.pharmacyapp.data.remote.mapper.Mapper.toPharmacyModel
import com.emreyigit98.pharmacyapp.domain.model.phamracy_model.PharmacyModel
import com.emreyigit98.pharmacyapp.domain.repo.PharmacyRepository
import com.emreyigit98.pharmacyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PharmacyUseCase @Inject constructor(
    private val pharmacyRepository: PharmacyRepository
) {
    fun allPharmacy(
        city : String,district : String,apiKey : String
    ) : Flow<Resource<List<PharmacyModel>>> = flow {
        try {
            emit(Resource.Loading())
            val responseList = pharmacyRepository.allPharmacyList(city = city, district = district, apiKey = apiKey)
            emit(Resource.Success(responseList.toPharmacyModel()))
        }catch (ioException : IOException) {
            emit(Resource.Error(ioException.message ?: ""))
        }catch (httpException : HttpException) {
            emit(Resource.Error(httpException.message ?: ""))
        }
    }
}