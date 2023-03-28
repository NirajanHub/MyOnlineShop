package com.practise.myonlinestore.presentation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.graphics.vector.ImageVector
import com.practise.myonlinestore.R
import com.practise.myonlinestore.navigation.Screens

sealed class BottomNavigationItems(
    var title: String,
    var icon: ImageVector,
    var screen_route: String
) {
    object Home : BottomNavigationItems(Screens.Home.name, Icons.Default.Home, Screens.Home.route)
    object WishList : BottomNavigationItems("WishList", Icons.Default.Favorite, "wishList")
    object Profile : BottomNavigationItems(Screens.Profile.name, Icons.Default.Person, Screens.Profile.route)
    object History : BottomNavigationItems("History", Icons.Default.Refresh, "history")
}


val bottomNavItems = listOf(
    BottomNavigationItems.Home,
    BottomNavigationItems.Profile,
    BottomNavigationItems.History,
    BottomNavigationItems.WishList,
)