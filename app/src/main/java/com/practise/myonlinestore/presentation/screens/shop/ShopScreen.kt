package com.practise.myonlinestore.presentation.screens.shop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.practise.myonlinestore.R
import com.practise.myonlinestore.domain.model.MenuItem
import com.practise.myonlinestore.navigation.Screens
import com.practise.myonlinestore.navigation.SetUpNavGraphForBottomNavigation
import com.practise.myonlinestore.presentation.bottomNavigation.bottomNavItems
import com.practise.myonlinestore.presentation.components.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShopScreen(
    navControllerForDrawer: NavController
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader(
                    icon = Icons.Default.Home,
                    headerText = "Header"
                )
                DrawerBody(items = listOf(
                    MenuItem(
                        id = "Profile",
                        icon = Icons.Default.Person,
                        contentDescription = "Profile",
                        title = Screens.Profile.name,
                        route = Screens.Profile.route
                    ),
                    MenuItem(
                        id = "Orders",
                        icon = Icons.Default.ShoppingCart,
                        contentDescription = "Orders",
                        title = "Orders",
                        route = Screens.Orders.route
                    ),
                    MenuItem(
                        id = "c",
                        icon = Icons.Default.Person,
                        contentDescription = "Preferences",
                        title = "Preferences",
                        route = Screens.Profile.route
                    ),
                    MenuItem(
                        id = "b",
                        icon = Icons.Default.Info,
                        contentDescription = "History",
                        title = "History",
                        route = Screens.Orders.route
                    ),
                ),
                    modifier = Modifier.fillMaxSize(),
                    onItemClick = {
                        scope.launch {
                            drawerState.close()
                        }
                        navControllerForDrawer.navigate(it.route)
                    }
                )
            }
        }, content = {
            val backStackEntry = navController.currentBackStackEntryAsState()
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                topBar = {
                    AppBar(
                        title = stringResource(id = R.string.app_name),
                        actionComposable = {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = "Shopping Cart"
                            )
                        },
                        navigationIcon = Icons.Default.Menu,
                    ) {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                },
                bottomBar = {
                    NavigationBar(containerColor = MaterialTheme.colorScheme.onPrimary) {
                        bottomNavItems.forEach { item ->
                            val selected =
                                item.screen_route == backStackEntry.value?.destination?.route
                            NavigationBarItem(
                                selected = selected,
                                onClick = {
                                    navController.navigate(item.screen_route) {
                                        navController.graph.startDestinationRoute?.let { screen_route ->
                                            popUpTo(screen_route) {
                                                saveState = true
                                            }
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                label = {
                                    Text(
                                        text = item.title,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                },
                                icon = {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }) {
                SetUpNavGraphForBottomNavigation(navController = navController, paddingValues = it)
            }
        })
}


//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ScaffoldContent(
//    paddingValues: PaddingValues = PaddingValues(10.dp),
//    navController: NavController
//) {
//    val verticalScrollState = rememberScrollState()
//    Column(
//        verticalArrangement = Arrangement.SpaceBetween,
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(
//                top = paddingValues.calculateTopPadding(),
//                start = 20.dp,
//                bottom = paddingValues.calculateBottomPadding(),
//            )
//            .verticalScroll(enabled = true, state = verticalScrollState)
//    ) {
//        Text(
//            text = AnnotatedString(
//                stringResource(
//                    id = R.string.delicious_food
//                ),
//                spanStyle = SpanStyle(
//                    fontFamily = Font(R.font.gilroybold).toFontFamily(),
//                    fontSize = 30.sp
//                )
//            ),
//            modifier = Modifier.padding(
//                horizontal = paddingValues.calculateLeftPadding(
//                    LayoutDirection.Ltr
//                ),
//            ),
//        )
//        SearchBar(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(100.dp)
//                .padding(
//                    top = 40.dp,
//                    end = 70.dp
//                ),
//            leadingIcon = {
//                Icon(
//                    Icons.Default.Search, "SEARCH"
//                )
//            },
//            query = "Hello",
//            onQueryChange = {},
//            onSearch = {},
//            active = false,
//            onActiveChange = {},
//        ) {}
//        LazyRow(modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 10.dp), content = {
//            items(listOfCategory.size) { index ->
//                CategoriesText(text = listOfCategory[index].text, onClicked = {
//                    navController.navigate(listOfCategory[index].route)
//                })
//            }
//        })
//        LazyRow(modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 20.dp), content = {
//            items(listOfFoodItems.size) { index ->
//                FoodItemComponent(
//                    modifier = Modifier
//                        .height(250.dp)
//                        .width(200.dp)
//                        .padding(
//                            top = 50.dp,
//                            end = 5.dp,
//                            start = 5.dp,
//                            bottom = 5.dp
//                        )
//                        .align(Alignment.CenterHorizontally),
//                    title = listOfFoodItems[index].title,
//                    image = listOfFoodItems[index].image,
//                    price = listOfFoodItems[index].price,
//                    onClicked = { navigationLink ->
//                        navController.navigate(navigationLink)
//                    }
//                )
//            }
//        })
//    }
//}
//
//
//
//
