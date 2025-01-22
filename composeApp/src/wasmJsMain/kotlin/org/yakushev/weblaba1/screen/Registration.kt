package org.yakushev.weblaba1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.jetbrains.compose.resources.stringResource
import org.yakushev.weblaba1.components.PrimaryButton
import org.yakushev.weblaba1.components.RegistrationTextField
import org.yakushev.weblaba1.components.TertiaryButton
import org.yakushev.weblaba1.components.TextTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(
    navController: NavHostController,
) {
    val viewModel = remember { RegistrationViewModel() }

    val state = viewModel.getState().collectAsState().value
    val uiAction = viewModel.getActionFlow().collectAsState(initial = null).value

    when (uiAction) {
        RegistrationViewModel.Action.Error -> RegistrationAlertDialog(
            title = "Error. Check your input.",
            dismiss = viewModel::onDialogShown,
            action = {},
        )
        RegistrationViewModel.Action.Success -> RegistrationAlertDialog(
            title = "Registration successful! Your credits will be sent to your phone.",
            dismiss = viewModel::onDialogShown,
            action = {
                navController.popBackStack()
            },
        )
        null -> Unit
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "Yakushev.Regisration",
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding).padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(state) { item ->
                RegistrationTextField(
                    value = item.value,
                    placeholder = item.enum.getPlaceholder(),
                    supportingText = item.supportingText,
                    onValueChange = {
                        viewModel.onValueChange(item.enum, it)
                    },
                    keyboardOptions = item.enum.getKeyboardOptions()
                )
            }
            item {
                PrimaryButton(text = "Registration") { viewModel.onRegistrationClicked() }
            }
        }
    }
}

@Composable
fun RegistrationAlertDialog(
    title: String,
    action: () -> Unit,
    dismiss: () -> Unit,
) {
    println("### alertTT")
    AlertDialog(
        onDismissRequest = { dismiss() },
        confirmButton = {
            TertiaryButton(
                textRes = "Okay",
                contentColor = MaterialTheme.colorScheme.error,
                onClick = {
                    dismiss()
                    action()
                }
            )
        },
        title = {
            TextTitle(text = title, maxLines = Int.MAX_VALUE)
        },
    )
}

fun RegistrationFieldEnum.getPlaceholder(): String = when (this) {
    RegistrationFieldEnum.NAME -> "Name"
    RegistrationFieldEnum.SURNAME -> "Surname"
    RegistrationFieldEnum.PATRONYMIC -> "Patronymic"
    RegistrationFieldEnum.PHONE -> "Phone"
}

fun RegistrationFieldEnum.getKeyboardOptions(): KeyboardOptions = when (this) {
    RegistrationFieldEnum.NAME,
    RegistrationFieldEnum.SURNAME,
    RegistrationFieldEnum.PATRONYMIC -> KeyboardOptions()
    RegistrationFieldEnum.PHONE -> KeyboardOptions(keyboardType = KeyboardType.Phone)
}
