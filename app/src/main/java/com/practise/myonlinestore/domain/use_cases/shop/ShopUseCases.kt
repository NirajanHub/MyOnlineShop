package com.practise.myonlinestore.domain.use_cases.shop

import com.practise.myonlinestore.domain.ShopRepository
import com.practise.myonlinestore.domain.model.Product
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow


class ShopUseCases(private val repository: ShopRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Product>>> =
        repository.getProducts()
}