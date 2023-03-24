package com.practise.myonlinestore.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val name:String,
    val price: Int,
    val image: String
):Parcelable

@Parcelize
data class ProductDetail(
    val  name:String,
    val  price: Int,
    val category: String,
): Parcelable