package com.practise.myonlinestore.presentation.screens.orders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.practise.myonlinestore.presentation.components.AppBar

@Composable
fun OrderScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Orders",
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationIconClick = {
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Button(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go Back")
            }
            Text(text = "Orders")
        }

    }
}