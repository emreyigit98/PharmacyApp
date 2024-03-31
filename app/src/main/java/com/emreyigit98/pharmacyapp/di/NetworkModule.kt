package com.emreyigit98.pharmacyapp.di

import com.emreyigit98.pharmacyapp.data.remote.api.PharmacyApi
import com.emreyigit98.pharmacyapp.data.repo.PharmacyRepositoryImpl
import com.emreyigit98.pharmacyapp.domain.repo.PharmacyRepository
import com.emreyigit98.pharmacyapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitObject() : Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providePharmacyApi(retrofit: Retrofit) : PharmacyApi {
        return retrofit.create(PharmacyApi::class.java)
    }

    @Provides
    @Singleton
    fun providePharmacyRepository(pharmacyApi: PharmacyApi) : PharmacyRepository {
        return PharmacyRepositoryImpl(pharmacyApi = pharmacyApi)
    }
}