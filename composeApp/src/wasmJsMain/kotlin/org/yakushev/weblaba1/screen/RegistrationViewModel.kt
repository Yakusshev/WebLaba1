package org.yakushev.weblaba1.screen

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {

    private val state = MutableStateFlow(value = getDefaultFields())
    private val actionFlow = MutableStateFlow<Action?>(value = null)

    fun getState(): StateFlow<List<RegistrationFieldUiModel>> = state
    fun getActionFlow(): StateFlow<Action?> = actionFlow

    private fun getDefaultFields(): List<RegistrationFieldUiModel> = listOf(
        RegistrationFieldUiModel(enum = RegistrationFieldEnum.NAME),
        RegistrationFieldUiModel(enum = RegistrationFieldEnum.SURNAME),
        RegistrationFieldUiModel(enum = RegistrationFieldEnum.PATRONYMIC),
        RegistrationFieldUiModel(enum = RegistrationFieldEnum.PHONE),
    )

    fun onValueChange(enum: RegistrationFieldEnum, text: String) {
        state.update { list ->
            list.map { field ->
                if (field.enum == enum) {
                    field.copy(value = text)
                } else {
                    field
                }
            }
        }
    }

    fun onDialogShown() {
        actionFlow.update { null }
    }

    fun onRegistrationClicked() {
        var error = false
        state.update { list ->
            list.map { field ->
                if (field.value.isNotBlank() && field.value.length > 3) {
                    field.copy(supportingText = "")
                } else {
                    error = true
                    field.copy(supportingText = "This field must contain at least 4 characters")
                }
            }
        }
        viewModelScope.launch {
            println("### onRegistrationClicked: error: $error")
            actionFlow.emit(if (error) Action.Error else Action.Success)
        }
    }

    sealed interface Action {
        data object Success : Action
        data object Error : Action
    }
}

enum class RegistrationFieldEnum {
    NAME,
    SURNAME,
    PATRONYMIC,
    PHONE,
}

data class RegistrationFieldUiModel(
    val value: String = "",
    val supportingText: String = "",
    val enum: RegistrationFieldEnum,
)