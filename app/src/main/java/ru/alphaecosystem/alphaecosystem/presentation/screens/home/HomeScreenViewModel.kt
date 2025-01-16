package ru.alphaecosystem.alphaecosystem.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain
import ru.alphaecosystem.alphaecosystem.domain.usecase.GetBinInfoUseCase
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.Mapper

class HomeScreenViewModel(
    private val getBinInfoUseCase: GetBinInfoUseCase,
    private val mapper: Mapper,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState

    fun handleEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.NumberUpdate -> event.number.isEmptyOrInt()
            HomeScreenEvent.GetInfo -> {
                if (_uiState.value.cardNumber.length > 5) {
                    getBinInfo()
                } else {
                    _uiState.value = _uiState.value.copy(binInfo = null)
                }
            }
        }
    }

    private fun String.isEmptyOrInt() {
        if (this.isEmpty() || Regex("^\\d{0,16}$").matches(this)) {
            _uiState.value = _uiState.value.copy(cardNumber = this)
        }
    }

    private fun getBinInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val binInfoDomain = getBinInfoUseCase.execute(
                binDomain = BinDomain(number = _uiState.value.cardNumber)
            )
            _uiState.value = _uiState.value.copy(
                binInfo = binInfoDomain?.let {
                    with(mapper) {
                        fromBinInfoDomainToBinInfo(it)
                    }
                }
            )
        }
    }
}