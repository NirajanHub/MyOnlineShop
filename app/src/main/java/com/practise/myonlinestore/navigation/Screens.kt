package com.practise.myonlinestore.navigation

sealed class Screens(
    val name: String,
    val route: String
) {

    // Without Nav Bar or App Bar
    object SignUp : Screens("SignUp", "signup_screen")
    object Login : Screens("Login", "login_screen")
    object Shop : Screens("Shop", "shop_screen")
    object Orders : Screens("Orders", "orders_screen")

    //Navigation Graph
    object Profile : Screens("Profile", "profile_screen")
    object Home : Screens("Home", "home_screen")
}