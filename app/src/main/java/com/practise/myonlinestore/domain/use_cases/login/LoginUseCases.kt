package com.practise.myonlinestore.domain.use_cases.login

import com.practise.myonlinestore.domain.LoginRepository
import com.practise.myonlinestore.domain.model.LoginResult
import com.practise.myonlinestore.domain.model.LoginUser
import com.practise.myonlinestore.util.Resource
import kotlinx.coroutines.flow.Flow

class LoginUseCases (private val repository: LoginRepository) {

    suspend operator fun invoke(loginUser: LoginUser) : Flow<Resource<LoginResult>> =
        repository.invoke(loginUser)
}