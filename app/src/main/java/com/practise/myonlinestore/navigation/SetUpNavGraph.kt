package com.practise.myonlinestore.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practise.myonlinestore.presentation.screens.login.LoginScreen
import com.practise.myonlinestore.presentation.screens.signup.SignUpScreen

@ExperimentalFoundationApi
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ) {
        composable(route = Screens.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
    }
}