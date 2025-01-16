package ru.alphaecosystem.alphaecosystem.presentation.screens.history

sealed class HistoryScreenEvent {
    data class CardDelete(val number: String) : HistoryScreenEvent()
}