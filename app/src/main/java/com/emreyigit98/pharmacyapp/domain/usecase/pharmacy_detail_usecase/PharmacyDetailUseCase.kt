package com.emreyigit98.pharmacyapp.domain.usecase.pharmacy_detail_usecase

import com.emreyigit98.pharmacyapp.data.remote.mapper.Mapper.toPharmacyDetailModel
import com.emreyigit98.pharmacyapp.domain.model.pharmacy_detail_model.PharmacyDetailModel
import com.emreyigit98.pharmacyapp.domain.repo.PharmacyRepository
import com.emreyigit98.pharmacyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PharmacyDetailUseCase @Inject constructor(
    private val pharmacyRepository: PharmacyRepository
) {
    fun allPharmacyDetail(
        detailsId : Int,
        apiKey : String
    ) : Flow<Resource<List<PharmacyDetailModel>>> = flow {
        try {
            emit(Resource.Loading())
            val responseList = pharmacyRepository.allPharmacyDetail(detailsId = detailsId, apiKey = apiKey)
            emit(Resource.Success(data = responseList.toPharmacyDetailModel()))
        }catch (ioException : IOException) {
            emit(Resource.Error(ioException.message ?: ""))
        }catch (httpException : HttpException) {
            emit(Resource.Error(httpException.message ?: ""))
        }
    }
}