package com.practise.myonlinestore.presentation.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import com.practise.myonlinestore.R
import com.practise.myonlinestore.domain.model.MenuItem

@Composable
fun DrawerHeader(
    icon: ImageVector,
    headerText: String
) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo of navigation header"
        )
        Text(
            text = headerText,
            style = TextStyle(
                fontFamily = Font(R.font.gilroybold).toFontFamily()
            )
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier,
    itemTextStyle: TextStyle = TextStyle(fontStyle = FontStyle(R.font.gilroyregular)),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(Modifier.padding(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}