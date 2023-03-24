package com.practise.myonlinestore.domain

import com.practise.myonlinestore.domain.model.Product
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    suspend fun getProducts(): Flow<Resource<List<Product>>>
}