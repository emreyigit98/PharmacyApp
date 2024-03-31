package com.emreyigit98.pharmacyapp.domain.usecase.district_usecase

import com.emreyigit98.pharmacyapp.data.remote.mapper.Mapper.toDistrictModel
import com.emreyigit98.pharmacyapp.domain.model.district_model.DistrictModel
import com.emreyigit98.pharmacyapp.domain.repo.PharmacyRepository
import com.emreyigit98.pharmacyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DistrictUseCase @Inject constructor(
    private val pharmacyRepository: PharmacyRepository
) {
    fun allDistrict(
        city : String ,apiKey : String
    ) : Flow<Resource<List<DistrictModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = pharmacyRepository.allDistrictList(city = city, apiKey = apiKey)
            emit(Resource.Success(response.toDistrictModel()))
        }catch (ioException : IOException) {
            emit(Resource.Error(message = ioException.message ?: ""))
        }catch (httpException : HttpException) {
            emit(Resource.Error(message = httpException.message ?: ""))
        }
    }
}