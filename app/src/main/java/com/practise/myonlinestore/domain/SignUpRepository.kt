package com.practise.myonlinestore.domain

import com.practise.myonlinestore.domain.model.SignUpResult
import com.practise.myonlinestore.domain.model.SignUpUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow

interface SignUpRepository {
    suspend fun signUp(signUp: SignUpUser): Flow<Resource<SignUpResult>>
}