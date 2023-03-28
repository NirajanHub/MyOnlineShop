package com.practise.myonlinestore.domain.model

import android.os.Parcelable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val name: String,
    val price: Int,
    val image: String
) : Parcelable

@Parcelize
data class ProductDetail(
    val name: String,
    val price: Int,
    val category: String,
) : Parcelable


data class Category(val text: String, val route: String)
data class FoodComponent(
    val title: String,
    val price: String,
    val image: String
)
