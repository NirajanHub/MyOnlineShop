package com.practise.myonlinestore.presentation.screens.shop

import com.practise.myonlinestore.domain.model.Product


data class ShopStates(
    val productsList: List<Product>,
    val isLoading: Boolean,
    val error: String
)

data class ShopStatesViewModel(
    val productsList: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
) {
    fun toUiState(): ShopStates = ShopStates(
        productsList,
        isLoading,
        error
    )
}