package ru.alphaecosystem.alphaecosystem.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import ru.alphaecosystem.alphaecosystem.presentation.screens.history.HistoryScreen
import ru.alphaecosystem.alphaecosystem.presentation.screens.history.HistoryScreenViewModel
import ru.alphaecosystem.alphaecosystem.presentation.screens.home.HomeScreen
import ru.alphaecosystem.alphaecosystem.presentation.screens.home.HomeScreenViewModel
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.NameNavScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val vmHomeScreen = koinViewModel<HomeScreenViewModel>()
    val vmHistoryScreen = koinViewModel<HistoryScreenViewModel>()

    NavHost(navController = navController, startDestination = NameNavScreen.Home.route) {
        composable(route = NameNavScreen.Home.route) {
            HomeScreen(viewModel = vmHomeScreen, navController = navController)
        }
        composable(route = NameNavScreen.History.route) {
            HistoryScreen(viewModel = vmHistoryScreen, navController = navController)
        }
    }
}