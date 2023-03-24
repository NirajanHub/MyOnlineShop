package com.practise.myonlinestore.domain

import com.practise.myonlinestore.domain.model.LoginResult
import com.practise.myonlinestore.domain.model.LoginUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun invoke(loginUser: LoginUser): Flow<Resource<LoginResult>>
}