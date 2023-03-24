package com.practise.myonlinestore.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignUpUser(
    val name: String,
    val email: String,
    val password: String,
    val passwordConfirmation: String,
) : Parcelable

@Parcelize
data class SignUpResult(
    val name: String
) : Parcelable
