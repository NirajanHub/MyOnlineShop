package com.practise.myonlinestore.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class LoginUser(
    val email: String,
    val password: String
) : Parcelable

@Parcelize
data class LoginResult(
    val message: String
) : Parcelable