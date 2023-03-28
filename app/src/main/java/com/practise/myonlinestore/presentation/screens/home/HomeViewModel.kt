package com.practise.myonlinestore.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practise.myonlinestore.domain.use_cases.UseCases
import com.practise.myonlinestore.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    private val viewModelState = MutableStateFlow(ShopStatesViewModel())

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun getProducts() {
        viewModelScope.launch {
            useCases.shop.invoke().collect {
                viewModelState.update { state ->
                    when (it) {
                        is Resource.Success -> {
                            state.copy(
                                productsList = it.data!!,
                                isLoading = false,
                                error = ""
                            )
                        }
                        is Resource.Loading -> {
                            state.copy(
                                productsList = emptyList(),
                                isLoading = true,
                                error = ""
                            )
                        }
                        is Resource.Error -> {
                            state.copy(
                                productsList = emptyList(),
                                isLoading = true,
                                error = it.message.toString()
                            )
                        }
                    }
                }
            }
        }
    }
}