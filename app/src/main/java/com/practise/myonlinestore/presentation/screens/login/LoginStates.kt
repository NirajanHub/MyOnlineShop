package com.practise.myonlinestore.presentation.screens.login

data class LoginState(
    val isLoading: Boolean,
    val errorMessage: String,
    val passwordInput: String,
    val emailInput: String,
    val result: String,
    val showPassword: Boolean
)

data class LoginViewModelState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val passwordInput: String = "",
    val emailInput: String = "",
    val result: String = "",
    val showPassword: Boolean = false
) {
    fun toUiState(): LoginState = LoginState(
        isLoading,
        errorMessage,
        passwordInput,
        emailInput,
        result,
        showPassword
    )
}