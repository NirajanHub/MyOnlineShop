package com.practise.myonlinestore.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practise.myonlinestore.domain.model.LoginUser
import com.practise.myonlinestore.domain.use_cases.UseCases
import com.practise.myonlinestore.presentation.screens.signup.SignUpEvents
import com.practise.myonlinestore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val viewModelState = MutableStateFlow(LoginViewModelState())


    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    private val loginUser = LoginUser(
        email = uiState.value.emailInput,
        password = uiState.value.passwordInput
    )

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


    fun togglePassword(show: Boolean) {
        viewModelState.update {
            it.copy(showPassword = show)
        }
    }

    fun onEvent(events: LoginEvents) {
        when (events) {
            is LoginEvents.Login -> {
                viewModelScope.launch {
                    useCases.login.invoke(events.loginUser).collect { result ->
                        viewModelState.update { state ->
                            when (result) {
                                is Resource.Loading -> state.copy(
                                    isLoading = true,
                                    result = "",
                                    errorMessage = ""
                                )
                                is Resource.Error -> state.copy(
                                    isLoading = false,
                                    result = "",
                                    errorMessage = result.data?.message ?: "Error"
                                )
                                is Resource.Success -> state.copy(
                                    isLoading = false,
                                    result = result.data?.message ?: "Success",
                                    errorMessage = ""
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}