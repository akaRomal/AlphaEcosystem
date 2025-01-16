package ru.alphaecosystem.alphaecosystem.presentation.screens.history

import ru.alphaecosystem.alphaecosystem.presentation.screens.models.BinInfo

data class HistoryScreenState(
    val binInfoList: List<BinInfo> = emptyList(),
)
