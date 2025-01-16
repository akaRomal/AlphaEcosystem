package ru.alphaecosystem.alphaecosystem.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.alphaecosystem.alphaecosystem.presentation.screens.history.HistoryScreenViewModel
import ru.alphaecosystem.alphaecosystem.presentation.screens.home.HomeScreenViewModel
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.Mapper


val presentationModule = module {
    viewModel { HomeScreenViewModel(getBinInfoUseCase = get(), mapper = get()) }
    viewModel { HistoryScreenViewModel() }
    single<Mapper> { Mapper() }
}