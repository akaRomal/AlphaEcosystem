package ru.alphaecosystem.alphaecosystem.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
fun HomeScreen(viewModel: HomeScreenViewModel, navController: NavHostController) {

    val localFocusManager = LocalFocusManager.current
    val state = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            OutlinedTextField(
                value = state.cardNumber,
                onValueChange = { viewModel.handleEvent(HomeScreenEvent.NumberUpdate(number = it)) },
                modifier = Modifier.padding(all = 16.dp),
                singleLine = true,
                label = { Text(text = stringResource(id = R.string.text_label_number_card)) },
                trailingIcon = {
                    if (state.cardNumber.isNotEmpty()) {
                        IconButton(onClick = {
                            viewModel.handleEvent(HomeScreenEvent.NumberUpdate(number = ""))
                        }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = stringResource(id = R.string.description_icon_clear)
                            )
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Default
                ),
                keyboardActions = KeyboardActions(
                    onAny = {
                        localFocusManager.clearFocus()
                    }
                )
            )
            Row {
                Button(
                    onClick = { viewModel.handleEvent(HomeScreenEvent.GetInfo) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                ) {
                    Text(text = stringResource(id = R.string.text_button_search))
                }

                Button(
                    onClick = { navigateToScreen(navController = navController, screen = NameNavScreen.History) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),

                ) {
                    Text(text = stringResource(id = R.string.text_button_history))
                }

            }
        }

        ElevatedCard(
            modifier = Modifier.fillMaxSize(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            state.binInfo?.let { cardInfo ->
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    val context = LocalContext.current

                    CustomText(title = R.string.text_title_country, text = cardInfo.country)
                    CustomText(
                        title = R.string.text_title_coordinates,
                        text = cardInfo.coordinates?.let {
                            "${cardInfo.coordinates.latitude}, ${cardInfo.coordinates.longitude}"
                        } ?: "",
                        onClick = {
                            openMap(context = context, coordinates = cardInfo.coordinates)
                        })
                    CustomText(title = R.string.text_title_cardType, text = cardInfo.cardType)
                    CustomText(title = R.string.text_title_bankName, text = cardInfo.bankName)
                    CustomText(
                        title = R.string.text_title_bankUrl,
                        text = cardInfo.bankUrl,
                        onClick = { openUrl(context = context, url = cardInfo.bankUrl) })
                    CustomText(
                        title = R.string.text_title_bankTel,
                        text = cardInfo.bankTel,
                        onClick = { dialPhone(context = context, phone = cardInfo.bankTel) })
                    CustomText(title = R.string.text_title_bankCity, text = cardInfo.bankCity)

                }
            }
        }
    }
}