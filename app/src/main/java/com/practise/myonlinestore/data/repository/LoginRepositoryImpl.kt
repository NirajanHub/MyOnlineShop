package com.practise.myonlinestore.data.repository

import com.practise.myonlinestore.domain.LoginRepository
import com.practise.myonlinestore.domain.model.LoginResult
import com.practise.myonlinestore.domain.model.LoginUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl : LoginRepository {
    override suspend fun invoke(loginUser: LoginUser) = flow {
        val loginResult = LoginResult("")
        emit(Resource.Loading)
        kotlinx.coroutines.delay(500)
        emit(Resource.Success(loginResult))
    }
}