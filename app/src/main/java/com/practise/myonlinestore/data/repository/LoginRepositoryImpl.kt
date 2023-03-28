package com.practise.myonlinestore.data.repository

import com.practise.myonlinestore.domain.LoginRepository
import com.practise.myonlinestore.domain.model.LoginResult
import com.practise.myonlinestore.domain.model.LoginUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(loginUser: LoginUser) = flow {
        val loginResult = LoginResult("Login Successful")
        emit(Resource.Loading)
        delay(1000)
        emit(Resource.Success(loginResult))
    }
}