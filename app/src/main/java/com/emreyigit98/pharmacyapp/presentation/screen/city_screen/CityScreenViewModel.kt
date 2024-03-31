package com.emreyigit98.pharmacyapp.presentation.screen.city_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.pharmacyapp.domain.usecase.city_usecase.CityUseCase
import com.emreyigit98.pharmacyapp.util.Api
import com.emreyigit98.pharmacyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CityScreenViewModel @Inject constructor(
    private val cityUseCase: CityUseCase
) : ViewModel() {

    private val _cityState = mutableStateOf<CityScreenState>(CityScreenState())
    val cityState : State<CityScreenState> get() = _cityState

    init {
        allCity()
    }
    fun cityTryAgain() = allCity()

    private fun allCity() {
        cityUseCase.executeAllCity(apiKey = Api.API_KEY).onEach {
            when(it) {
                is Resource.Error -> {
                    _cityState.value = CityScreenState(error = it.message ?: "")
                }
                is Resource.Loading -> {
                    _cityState.value = CityScreenState(loading = true)
                }
                is Resource.Success -> {
                    _cityState.value = CityScreenState(responseCityList = it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}