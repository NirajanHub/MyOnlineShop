package com.practise.myonlinestore.presentation.screens.orders

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.practise.myonlinestore.presentation.components.AppBar

@Composable
fun OrderScreen(
    navController: NavController,
) {
    Scaffold(topBar = {
        AppBar(title = "Orders",
            navigationIcon = Icons.Default.ArrowBack,
            onNavigationIconClick = {
                navController.popBackStack()
            })
    }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "No Orders Found",
                modifier = Modifier.size(200.dp),
                tint = MaterialTheme.colorScheme.surfaceTint,
            )
            Text(text = "No orders Yet")
        }

    }
}