package ru.alphaecosystem.alphaecosystem.presentation.screens.home

sealed class HomeScreenEvent {
    data class NumberUpdate(val number: String) : HomeScreenEvent()
    data object GetInfo : HomeScreenEvent()
}