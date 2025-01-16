package ru.alphaecosystem.alphaecosystem.presentation.screens.history

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HistoryScreenViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(HistoryScreenState())
    val uiState: StateFlow<HistoryScreenState> = _uiState

    fun handleEvent(event: HistoryScreenEvent){
        when(event){
            is HistoryScreenEvent.CardDelete -> TODO()
        }
    }
}