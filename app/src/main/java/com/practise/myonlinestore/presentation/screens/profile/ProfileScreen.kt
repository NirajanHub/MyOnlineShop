package com.practise.myonlinestore.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Text(text = "Profile")
    }
}