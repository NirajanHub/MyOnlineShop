package com.practise.myonlinestore.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val icon: ImageVector,
    val contentDescription: String,
    val title: String,
    val route : String,
)
