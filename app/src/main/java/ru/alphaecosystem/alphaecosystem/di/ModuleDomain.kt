package ru.alphaecosystem.alphaecosystem.di

import org.koin.dsl.module
import ru.alphaecosystem.alphaecosystem.domain.usecase.DeleteDinUseCase
import ru.alphaecosystem.alphaecosystem.domain.usecase.GetAllBankInfoUseCase
import ru.alphaecosystem.alphaecosystem.domain.usecase.GetBinInfoUseCase

val domainModule = module {
    single<GetBinInfoUseCase> { GetBinInfoUseCase(repository = get()) }

    single<GetAllBankInfoUseCase> { GetAllBankInfoUseCase(repository = get()) }

    single<DeleteDinUseCase> { DeleteDinUseCase(repository = get()) }
}