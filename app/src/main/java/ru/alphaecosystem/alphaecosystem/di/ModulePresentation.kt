package ru.alphaecosystem.alphaecosystem.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.alphaecosystem.alphaecosystem.presentation.screens.history.HistoryScreenViewModel
import ru.alphaecosystem.alphaecosystem.presentation.screens.home.HomeScreenViewModel


val presentationModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { HistoryScreenViewModel() }
}