package com.practise.myonlinestore.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import com.practise.myonlinestore.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String = stringResource(id = R.string.app_name),
    actionComposable: @Composable RowScope.() -> Unit = {},
    navigationIcon : ImageVector,
    onNavigationIconClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                fontFamily = Font(R.font.gilroybold).toFontFamily(),
                text = title,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavigationIconClick()
                }) {
                Icon(
                    navigationIcon,
                    contentDescription = "Toggle drawer"
                )
            }
        },
        actions = {
            actionComposable()
        }
    )
}