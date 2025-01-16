package ru.alphaecosystem.alphaecosystem.presentation.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain
import ru.alphaecosystem.alphaecosystem.domain.usecase.DeleteDinUseCase
import ru.alphaecosystem.alphaecosystem.domain.usecase.GetAllBankInfoUseCase
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.Mapper

class HistoryScreenViewModel(
    private val getAllBankInfoUseCase: GetAllBankInfoUseCase,
    private val deleteDinUseCase: DeleteDinUseCase,
    private val mapper: Mapper,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HistoryScreenState())
    val uiState: StateFlow<HistoryScreenState> = _uiState

    init {
        getAllBinInfo()
    }

    fun handleEvent(event: HistoryScreenEvent) {
        when (event) {
            is HistoryScreenEvent.CardDelete -> deleteBin(event.number)
        }
    }

    private fun getAllBinInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllBankInfoUseCase.execute()
                .collect { binsInfo ->
                    val binInfoList = binsInfo.let(mapper::fromBinInfoDomainToHistoryScreenState)
                    _uiState.value = _uiState.value.copy(binInfoList = binInfoList)
                }
        }
    }

    private fun deleteBin(numberBin: String){
        viewModelScope.launch(Dispatchers.IO) {
            deleteDinUseCase.execute(binDomain = BinDomain(number = numberBin))
        }
    }
}