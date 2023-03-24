package com.practise.myonlinestore.presentation.screens.login

import com.practise.myonlinestore.domain.model.LoginUser

sealed class LoginEvents {
    data class Login(
        val loginUser: LoginUser
    ) : LoginEvents()
}