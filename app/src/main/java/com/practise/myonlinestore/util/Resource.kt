package com.practise.myonlinestore.util

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<T>(var data: T? = null) : Resource<T>()
    data class Error<T>(var data: T? = null, var message: String? = null) : Resource<T>()
}

enum class ResourceState {
    SUCCESS,
    LOADING,
    ERROR
}
