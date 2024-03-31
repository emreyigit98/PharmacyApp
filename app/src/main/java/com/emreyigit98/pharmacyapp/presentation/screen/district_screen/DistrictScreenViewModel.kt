package com.emreyigit98.pharmacyapp.presentation.screen.district_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.pharmacyapp.domain.usecase.district_usecase.DistrictUseCase
import com.emreyigit98.pharmacyapp.presentation.navigation.CityScreenDestination
import com.emreyigit98.pharmacyapp.presentation.navigation.DistrictScreenDestination
import com.emreyigit98.pharmacyapp.util.Api
import com.emreyigit98.pharmacyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DistrictScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val districtUseCase: DistrictUseCase
) : ViewModel() {

    private val _districtScreenState = mutableStateOf<DistrictScreenState>(DistrictScreenState())
    val districtScreenState : State<DistrictScreenState> get() = _districtScreenState

    private val getCityArgument : String = checkNotNull(savedStateHandle[DistrictScreenDestination.argument])

    init {
        allDistrict(city = getCityArgument)
    }
    fun resetDistrict() = allDistrict(city = getCityArgument)

    private fun allDistrict(city : String) {
        districtUseCase.allDistrict(city = city, apiKey = Api.API_KEY).onEach {
            when(it) {
                is Resource.Error -> {
                    _districtScreenState.value = DistrictScreenState(error = it.message ?: "")
                }
                is Resource.Loading -> {
                    _districtScreenState.value = DistrictScreenState(loading = true)
                }
                is Resource.Success -> {
                    _districtScreenState.value = DistrictScreenState(districtList = it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

}