package com.practise.myonlinestore.domain.use_cases.sign_up

import com.practise.myonlinestore.domain.SignUpRepository
import com.practise.myonlinestore.domain.model.SignUpResult
import com.practise.myonlinestore.domain.model.SignUpUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow

class SignUpUseCases(private val repository: SignUpRepository) {
    suspend operator fun invoke(signUp: SignUpUser): Flow<Resource<SignUpResult>> =
        repository.signUp(signUp)
}