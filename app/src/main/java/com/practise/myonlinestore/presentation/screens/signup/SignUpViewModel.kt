package com.practise.myonlinestore.presentation.screens.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practise.myonlinestore.domain.use_cases.UseCases
import com.practise.myonlinestore.util.Resource
import com.practise.myonlinestore.util.parseErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val viewModelState = MutableStateFlow(SignUpViewModelState())

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun onNameInputChanged(nameInput: String) {
        viewModelState.update {
            it.copy(nameInput = nameInput)
        }
    }

    fun onEmailInputChanged(emailInput: String) {
        viewModelState.update {
            it.copy(emailInput = emailInput)
        }
    }

    fun onPasswordInputChanged(passwordInput: String) {
        viewModelState.update {
            it.copy(passwordInput = passwordInput)
        }
    }

    fun onConfirmPasswordInputChanged(confirmPasswordInput: String) {
        viewModelState.update {
            it.copy(confirmPasswordInput = confirmPasswordInput)
        }
    }

    fun togglePassword(show: Boolean) {
        viewModelState.update {
            it.copy(showPassword = show)
        }
    }

    fun onEvents(event: SignUpEvents) {
        when (event) {
            is SignUpEvents.SignUp -> {
                viewModelScope.launch {
                    useCases.signUp.invoke(event.signupUser).collect { result ->
                        viewModelState.update { state ->
                            when (result) {
                                is Resource.Success -> state.copy(
                                    result = "Some result",
                                    errorMessage = "",
                                    isLoading = false
                                )
                                is Resource.Error -> {
                                    state.copy(
                                        errorMessage = parseErrorMessage(result.message ?: "Error"),
                                        isLoading = false,
                                        result = ""
                                    )
                                }
                                is Resource.Loading ->
                                    state.copy(
                                        isLoading = true,
                                        errorMessage = "",
                                        result = ""
                                    )
                            }
                        }
                    }
                }
            }
        }
    }
}