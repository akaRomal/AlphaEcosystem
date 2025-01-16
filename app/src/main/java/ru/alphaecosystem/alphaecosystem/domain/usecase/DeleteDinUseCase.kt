package ru.alphaecosystem.alphaecosystem.domain.usecase

import ru.alphaecosystem.alphaecosystem.domain.interfaces.Repository
import ru.alphaecosystem.alphaecosystem.domain.models.BinDomain

class DeleteDinUseCase(private val repository: Repository) {
    suspend fun execute(binDomain: BinDomain) {
        repository.deleteBin(binCard = binDomain)
    }
}