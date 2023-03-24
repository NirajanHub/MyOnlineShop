package com.practise.myonlinestore.presentation.screens.signup

data class SignUpState(
    val isLoading: Boolean,
    val errorMessage: String,
    val nameInput: String,
    val passwordInput: String,
    val confirmPasswordInput: String,
    val emailInput: String,
    val result: String,
    val showPassword: Boolean
)

data class SignUpViewModelState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val nameInput: String = "",
    val passwordInput: String = "",
    val confirmPasswordInput: String = "",
    val emailInput: String = "",
    val result: String = "",
    val showPassword: Boolean = false
) {
    fun toUiState(): SignUpState = SignUpState(
        isLoading,
        errorMessage,
        nameInput,
        passwordInput,
        confirmPasswordInput,
        emailInput,
        result,
        showPassword
    )
}