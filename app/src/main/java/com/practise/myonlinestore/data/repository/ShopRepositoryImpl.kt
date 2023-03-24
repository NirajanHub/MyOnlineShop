package com.practise.myonlinestore.data.repository

import com.practise.myonlinestore.domain.ShopRepository
import com.practise.myonlinestore.domain.model.Product
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class ShopRepositoryImpl : ShopRepository {
    override suspend fun getProducts() = flow {
        emit(Resource.Loading)
        delay(500)
        emit(Resource.Success(data = getProductForContent()))
    }
}

fun getProductForContent(): List<Product> {
    return listOf(
        Product(
            "a",
            10,
            "https://images.pexels.com/photos/4406191/pexels-photo-4406191.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "b",
            20,
            "https://images.pexels.com/photos/15164033/pexels-photo-15164033.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "c",
            40,
            "https://images.pexels.com/photos/6632711/pexels-photo-6632711.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "d",
            60,
            "https://images.pexels.com/photos/4187616/pexels-photo-4187616.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "e",
            90,
            "https://images.pexels.com/photos/12279474/pexels-photo-12279474.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "a",
            10,
            "https://images.pexels.com/photos/4406191/pexels-photo-4406191.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "b",
            20,
            "https://images.pexels.com/photos/15164033/pexels-photo-15164033.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "c",
            40,
            "https://images.pexels.com/photos/6632711/pexels-photo-6632711.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "d",
            60,
            "https://images.pexels.com/photos/4187616/pexels-photo-4187616.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "e",
            90,
            "https://images.pexels.com/photos/12279474/pexels-photo-12279474.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "a",
            10,
            "https://images.pexels.com/photos/4406191/pexels-photo-4406191.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "b",
            20,
            "https://images.pexels.com/photos/15164033/pexels-photo-15164033.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "c",
            40,
            "https://images.pexels.com/photos/6632711/pexels-photo-6632711.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "d",
            60,
            "https://images.pexels.com/photos/4187616/pexels-photo-4187616.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
        Product(
            "e",
            90,
            "https://images.pexels.com/photos/12279474/pexels-photo-12279474.jpeg?auto=compress&cs=tinysrgb&w=1600&lazy=load"
        ),
    )
}