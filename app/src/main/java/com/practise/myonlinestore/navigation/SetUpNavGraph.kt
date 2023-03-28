package com.practise.myonlinestore.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practise.myonlinestore.presentation.screens.home.HomeScreen
import com.practise.myonlinestore.presentation.screens.login.LoginScreen
import com.practise.myonlinestore.presentation.screens.orders.OrderScreen
import com.practise.myonlinestore.presentation.screens.profile.ProfileScreen
import com.practise.myonlinestore.presentation.screens.shop.ShopScreen
import com.practise.myonlinestore.presentation.screens.signup.SignUpScreen

@ExperimentalFoundationApi
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Shop.route
    ) {
        composable(route = Screens.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screens.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screens.Shop.route) {
            ShopScreen(navControllerForDrawer = navController)
        }
        composable(route = Screens.Orders.route) {
            OrderScreen(navController = navController)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun SetUpNavGraphForBottomNavigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            HomeScreen(
                navController = navController,
                paddingValues = paddingValues
            )
        }
        composable(route = Screens.Profile.route) {
            ProfileScreen(
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }
}

