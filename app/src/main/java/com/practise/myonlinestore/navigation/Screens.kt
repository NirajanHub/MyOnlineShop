package com.practise.myonlinestore.navigation

sealed class Screens(
    val route: String
) {
    object SignUp : Screens("signup_screen")
    object Login : Screens("login_screen")
    object Shop : Screens("shop_screen")
}