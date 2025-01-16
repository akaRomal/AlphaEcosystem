package ru.alphaecosystem.alphaecosystem.presentation.screens.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavHostController
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.Coordinates
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.NameNavScreen

fun openUrl(context: Context, url: String?) {
    if (url != null) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}

fun dialPhone(context: Context, phone: String?) {
    if (phone != null) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
        context.startActivity(intent)
    }
}

fun openMap(context: Context, coordinates: Coordinates?) {
    if (coordinates != null) {
        val uri = "geo:${coordinates.latitude},${coordinates.longitude}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        context.startActivity(intent)
    }
}

fun navigateToScreen(navController: NavHostController, screen: NameNavScreen){
    navController.navigate(screen.route) {
        popUpTo(navController.graph.startDestinationId){
            inclusive = true
        }
    }
}