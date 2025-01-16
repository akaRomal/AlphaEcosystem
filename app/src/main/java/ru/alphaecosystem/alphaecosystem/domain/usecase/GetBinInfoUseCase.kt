package ru.alphaecosystem.alphaecosystem.domain.usecase

import ru.alphaecosystem.alphaecosystem.domain.interfaces.Repository
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain
import ru.alphaecosystem.alphaecosystem.domain.models.BinInfoDomain

class GetBinInfoUseCase(private val repository: Repository) {
    suspend fun execute(binDomain: BinDomain): BinInfoDomain?{
        return repository.getBinInfo(binCard = binDomain)
    }
}