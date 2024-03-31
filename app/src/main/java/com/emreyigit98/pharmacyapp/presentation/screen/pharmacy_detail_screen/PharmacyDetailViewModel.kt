package com.emreyigit98.pharmacyapp.presentation.screen.pharmacy_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreyigit98.pharmacyapp.domain.usecase.pharmacy_detail_usecase.PharmacyDetailUseCase
import com.emreyigit98.pharmacyapp.presentation.navigation.PharmacyDetailScreenDestination
import com.emreyigit98.pharmacyapp.presentation.navigation.PharmacyScreenDestination
import com.emreyigit98.pharmacyapp.util.Api
import com.emreyigit98.pharmacyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PharmacyDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val pharmacyDetailUseCase: PharmacyDetailUseCase
) : ViewModel() {

    private val _pharmacyDetailState = mutableStateOf<PharmacyDetailState>(PharmacyDetailState())
    val pharmacyDetailState: State<PharmacyDetailState> get() = _pharmacyDetailState

    private val pharmacyDetailArgument: String =
        checkNotNull(savedStateHandle[PharmacyDetailScreenDestination.argument])

    init {
        allPharmacyDetail(detailsId = pharmacyDetailArgument.toInt(), apiKey = Api.API_KEY)
    }
    fun resetPharmacyDetail() = allPharmacyDetail(detailsId = pharmacyDetailArgument.toInt(), apiKey = Api.API_KEY)
    private fun allPharmacyDetail(
        detailsId: Int,
        apiKey: String
    ) {
        pharmacyDetailUseCase.allPharmacyDetail(detailsId = detailsId, apiKey = apiKey).onEach {
            when(it) {
                is Resource.Error -> {
                    _pharmacyDetailState.value = PharmacyDetailState(error = it.message ?: "")
                }
                is Resource.Loading -> {
                    _pharmacyDetailState.value = PharmacyDetailState(loading = true)
                }
                is Resource.Success -> {
                    _pharmacyDetailState.value = PharmacyDetailState(pharmacyDetailList = it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}