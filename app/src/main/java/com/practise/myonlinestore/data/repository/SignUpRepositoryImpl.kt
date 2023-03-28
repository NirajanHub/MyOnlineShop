package com.practise.myonlinestore.data.repository

import com.practise.myonlinestore.domain.SignUpRepository
import com.practise.myonlinestore.domain.model.SignUpResult
import com.practise.myonlinestore.domain.model.SignUpUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class SignUpRepositoryImpl : SignUpRepository {
    override suspend fun signUp(signUp: SignUpUser) = flow {
        emit(
            Resource.Loading
        )
        delay(1000)
        emit(
            Resource.Success(
                data = SignUpResult(
                    "allowSignUp"
                )
            )
        )
    }
}