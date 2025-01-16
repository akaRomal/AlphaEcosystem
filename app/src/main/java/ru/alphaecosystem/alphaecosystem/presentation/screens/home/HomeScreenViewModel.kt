package ru.alphaecosystem.alphaecosystem.presentation.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeScreenViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState: StateFlow<HomeScreenState> = _uiState

    fun handleEvent(event: HomeScreenEvent) {
        when(event){
            is HomeScreenEvent.NumberUpdate -> event.number.isInt()
            HomeScreenEvent.GetInfo -> TODO()
        }
    }

    private fun String.isInt() {
        if (this.isEmpty() || Regex("^\\d{0,16}$").matches(this)) {
            _uiState.value = _uiState.value.copy(cardNumber = this)
        }
    }

}