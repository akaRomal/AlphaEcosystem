package ru.alphaecosystem.alphaecosystem.presentation.screens.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.alphaecosystem.alphaecosystem.R
import ru.alphaecosystem.alphaecosystem.presentation.screens.components.CustomText
import ru.alphaecosystem.alphaecosystem.presentation.screens.components.dialPhone
import ru.alphaecosystem.alphaecosystem.presentation.screens.components.navigateToScreen
import ru.alphaecosystem.alphaecosystem.presentation.screens.components.openMap
import ru.alphaecosystem.alphaecosystem.presentation.screens.components.openUrl
import ru.alphaecosystem.alphaecosystem.presentation.screens.models.NameNavScreen

@Composable
fun HistoryScreen(viewModel: HistoryScreenViewModel, navController: NavHostController) {

    val state = viewModel.uiState.collectAsState().value

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(color = Color.Cyan)
        ) {
            IconButton(onClick = {
                navigateToScreen(navController = navController, screen = NameNavScreen.Home)
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.description_icon_back)
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.binInfoList) { cardInfo ->

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        val context = LocalContext.current

                        CustomText(
                            title = R.string.text_title_card_number,
                            text = cardInfo.cardNumber
                        )

                        CustomText(title = R.string.text_title_country, text = cardInfo.country)
                        CustomText(
                            title = R.string.text_title_coordinates,
                            text = cardInfo.coordinates?.let {
                                "${cardInfo.coordinates.latitude}, ${cardInfo.coordinates.longitude}"
                            } ?: "",
                            onClick = {
                                openMap(context = context, coordinates = cardInfo.coordinates)
                            })
                        CustomText(
                            title = R.string.text_title_cardType,
                            text = cardInfo.cardType
                        )
                        CustomText(
                            title = R.string.text_title_bankName,
                            text = cardInfo.bankName
                        )
                        CustomText(
                            title = R.string.text_title_bankUrl,
                            text = cardInfo.bankUrl,
                            onClick = {
                                openUrl(
                                    context = context,
                                    url = cardInfo.bankUrl
                                )
                            })
                        CustomText(
                            title = R.string.text_title_bankTel,
                            text = cardInfo.bankTel,
                            onClick = {
                                dialPhone(
                                    context = context,
                                    phone = cardInfo.bankTel
                                )
                            })
                        CustomText(
                            title = R.string.text_title_bankCity,
                            text = cardInfo.bankCity
                        )

                        Text(
                            text = stringResource(id = R.string.text_button_delete),
                            modifier = Modifier
                                .align(alignment = Alignment.End)
                                .clickable(
                                    onClick = {
                                        viewModel.handleEvent(
                                            HistoryScreenEvent.CardDelete(number = cardInfo.cardNumber)
                                        )
                                    }
                                ),
                            color = Color.Blue
                        )
                    }
                }
            }
        }
    }
}