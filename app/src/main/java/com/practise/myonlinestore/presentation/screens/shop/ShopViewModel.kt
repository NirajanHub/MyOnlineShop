package com.practise.myonlinestore.presentation.screens.shop

import androidx.lifecycle.ViewModel
import com.practise.myonlinestore.domain.use_cases.UseCases
import com.practise.myonlinestore.domain.use_cases.shop.ShopUseCases
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ShopViewModel(
    val useCases: UseCases
) : ViewModel() {

}