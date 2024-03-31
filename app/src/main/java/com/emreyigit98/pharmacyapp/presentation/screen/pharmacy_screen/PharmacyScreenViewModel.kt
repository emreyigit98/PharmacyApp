package com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.pharmacyapp.domain.usecase.pharmacy_usecase.PharmacyUseCase
import com.emreyigit98.pharmacyapp.presentation.navigation.PharmacyScreenDestination
import com.emreyigit98.pharmacyapp.util.Api
import com.emreyigit98.pharmacyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PharmacyScreenViewModel @Inject constructor(
    private val pharmacyUseCase: PharmacyUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _pharmacyState = mutableStateOf<PharmacyState>(PharmacyState())
    val pharmacyState: State<PharmacyState> get() = _pharmacyState

    private val cityArg: String = checkNotNull(savedStateHandle[PharmacyScreenDestination.argument])
    private val districtArg: String =
        checkNotNull(savedStateHandle[PharmacyScreenDestination.argumentDistrict])

    init {
        allPharmacy(
            city = cityArg,
            district = districtArg,
            apiKey = Api.API_KEY
        )
    }

    fun resetPharmacy() = allPharmacy(city = cityArg, district = districtArg, apiKey = Api.API_KEY)

    private fun allPharmacy(
        city: String,
        district: String,
        apiKey: String
    ) {
        pharmacyUseCase.allPharmacy(city = city, district = district, apiKey = apiKey).onEach {
            when (it) {
                is Resource.Error -> {
                    _pharmacyState.value = PharmacyState(error = it.message ?: "")
                }

                is Resource.Loading -> {
                    _pharmacyState.value = PharmacyState(loading = true)
                }

                is Resource.Success -> {
                    _pharmacyState.value = PharmacyState(pharmacyList = it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}