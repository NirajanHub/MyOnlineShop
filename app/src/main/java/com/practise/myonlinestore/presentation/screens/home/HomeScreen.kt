package com.practise.myonlinestore.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.practise.myonlinestore.R
import com.practise.myonlinestore.presentation.components.CategoriesText
import com.practise.myonlinestore.presentation.components.FoodItemComponent
import com.practise.myonlinestore.presentation.components.listOfCategory
import com.practise.myonlinestore.presentation.components.listOfFoodItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    navController: NavController
) {
    val verticalScrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                paddingValues,
            )
            .verticalScroll(enabled = true, state = verticalScrollState)
    ) {
        Text(
            text = AnnotatedString(
                stringResource(
                    id = R.string.delicious_food
                ),
                spanStyle = SpanStyle(
                    fontFamily = Font(R.font.gilroybold).toFontFamily(),
                    fontSize = 30.sp
                )
            ),
            modifier = Modifier.padding(
                horizontal = 20.dp
            ),
        )
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(
                    top = 40.dp,
                    end = 20.dp,
                    start = 20.dp
                ),
            leadingIcon = {
                Icon(
                    Icons.Default.Search, "SEARCH"
                )
            },
            query = "Hello",
            onQueryChange = {},
            onSearch = {},
            active = false,
            onActiveChange = {},
        ) {}
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp), content = {
            items(listOfCategory.size) { index ->
                CategoriesText(text = listOfCategory[index].text, onClicked = {
                    navController.navigate(listOfCategory[index].route)
                })
            }
        })
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp), content = {
            items(listOfFoodItems.size) { index ->
                FoodItemComponent(
                    modifier = Modifier
                        .height(250.dp)
                        .width(200.dp)
                        .padding(
                            top = 50.dp,
                            end = 5.dp,
                            start = 5.dp,
                            bottom = 5.dp
                        )
                        .align(Alignment.CenterHorizontally),
                    title = listOfFoodItems[index].title,
                    image = listOfFoodItems[index].image,
                    price = listOfFoodItems[index].price,
                    onClicked = { navigationLink ->
                        navController.navigate(navigationLink)
                    }
                )
            }
        })
    }
}