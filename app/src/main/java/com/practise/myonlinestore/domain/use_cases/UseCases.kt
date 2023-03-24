package com.practise.myonlinestore.domain.use_cases

import com.practise.myonlinestore.domain.use_cases.login.LoginUseCases
import com.practise.myonlinestore.domain.use_cases.shop.ShopUseCases
import com.practise.myonlinestore.domain.use_cases.sign_up.SignUpUseCases

data class UseCases(
    val signUp: SignUpUseCases,
    val login : LoginUseCases,
    val shop : ShopUseCases
)
