package com.practise.myonlinestore.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.practise.myonlinestore.R
import com.practise.myonlinestore.domain.model.Category
import com.practise.myonlinestore.domain.model.FoodComponent
import com.practise.myonlinestore.navigation.Screens

@Composable
@Preview
fun FoodItemComponent(
    modifier: Modifier = Modifier,
    title: String = "Food Title",
    price: String = "Rs 500",
    image: String = "",
    onClicked: (String) -> Unit = {},
) {
    Box(
        modifier = Modifier.clickable {
            onClicked("title")
        }
    ) {
        Card(
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    AnnotatedString(
                        text = title, spanStyle = SpanStyle(
                            fontStyle = FontStyle(R.font.gilroybold),
                            fontSize = 25.sp,
                        )
                    )
                )
                Text(
                    AnnotatedString(
                        text = price, spanStyle = SpanStyle(
                            fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
                            fontWeight = FontWeight.Bold
                        )
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        AsyncImage(
            model = image,
            contentDescription = title,
            contentScale = ContentScale.Crop, // crop the image if it's not a square
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape) // clip to the circle shape
                .align(Alignment.TopCenter), // add a border (optional)
            alignment = Alignment.Center
        )
    }
}

@Composable
fun CategoriesText(
    text: String,
    onClicked: (String) -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClicked(text) }
    ) {
        MyMediumText(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = text,
        )
        Divider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 1.dp,
            modifier = Modifier.width(50.dp)
        )
    }
}

val listOfCategory = listOf(
    Category(text = "Thai", Screens.Shop.route),
    Category(text = "Chinese", Screens.Login.route),
    Category(text = "Nepali", Screens.Shop.route),
    Category(text = "Indian", Screens.Shop.route),
    Category(text = "Vietnamese", Screens.Shop.route),
    Category(text = "Arabic", Screens.Shop.route),
)

val listOfFoodItems = listOf(
    FoodComponent(
        "Mo:Mo",
        "Rs 100",
        "https://www.thespruceeats.com/thmb/lsijER0oTpG00KaqDQMIOOaC930=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/IMG_8566-cbac2c001d5d4b9c923589fc18d9c108.jpg"
    ),
    FoodComponent(
        "Burger",
        "Rs 100",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjcI1w40FW3hpDD4VJW9Nr88yYoDV2ZMy0pw&usqp=CAU"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHCk_XZtyNO1LtOcVGYv3ajJpw6jBnP7GKeg&usqp=CAU"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://img.theculturetrip.com/wp-content/uploads/2019/07/hwhxn4.jpg"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTL-aAelzbXT1o1ZNC8vHtIWJB6OeXRL9h3NOPbzi12YoINoiQ39vEZDvB-J7vfXX1Zdk&usqp=CAU"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://www.thespruceeats.com/thmb/lsijER0oTpG00KaqDQMIOOaC930=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/IMG_8566-cbac2c001d5d4b9c923589fc18d9c108.jpg"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjcI1w40FW3hpDD4VJW9Nr88yYoDV2ZMy0pw&usqp=CAU"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHCk_XZtyNO1LtOcVGYv3ajJpw6jBnP7GKeg&usqp=CAU"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://img.theculturetrip.com/wp-content/uploads/2019/07/hwhxn4.jpg"
    ),
    FoodComponent(
        "title",
        "Rs 100",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTL-aAelzbXT1o1ZNC8vHtIWJB6OeXRL9h3NOPbzi12YoINoiQ39vEZDvB-J7vfXX1Zdk&usqp=CAU"
    ),

    )
