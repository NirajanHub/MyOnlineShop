package com.practise.myonlinestore.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun LoadingButton(
    text: String = "",
    isLoading: Boolean = false,
    enabled: Boolean = false,
    onClicked: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 50.dp, end = 50.dp)
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        50.dp
                    ),
                enabled = enabled,
                shape = RoundedCornerShape(30),
                onClick = { onClicked() }
            ) {
                Text(text = text, style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}