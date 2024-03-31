package com.emreyigit98.pharmacyapp.domain.usecase.city_usecase

import com.emreyigit98.pharmacyapp.data.remote.mapper.Mapper.toCityModel
import com.emreyigit98.pharmacyapp.domain.model.city_model.CityModel
import com.emreyigit98.pharmacyapp.domain.repo.PharmacyRepository
import com.emreyigit98.pharmacyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CityUseCase @Inject constructor (
    private val pharmacyRepository: PharmacyRepository
) {
    fun executeAllCity(apiKey : String) : Flow<Resource<List<CityModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = pharmacyRepository.allCityList(apiKey = apiKey)
            emit(Resource.Success(response.toCityModel()))
        }catch (ioException : IOException) {
            emit(Resource.Error(message = ioException.message ?: ""))
        }catch (httpException : HttpException) {
            emit(Resource.Error(message = httpException.message ?: ""))
        }
    }
}