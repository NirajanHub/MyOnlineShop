package com.practise.myonlinestore.presentation.screens.signup

import com.practise.myonlinestore.domain.model.SignUpUser

sealed class SignUpEvents {
    data class SignUp(val signupUser: SignUpUser) : SignUpEvents()
}