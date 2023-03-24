package com.practise.myonlinestore.di

import com.practise.myonlinestore.data.repository.LoginRepositoryImpl
import com.practise.myonlinestore.data.repository.ShopRepositoryImpl
import com.practise.myonlinestore.data.repository.SignUpRepositoryImpl
import com.practise.myonlinestore.domain.LoginRepository
import com.practise.myonlinestore.domain.ShopRepository
import com.practise.myonlinestore.domain.SignUpRepository
import com.practise.myonlinestore.domain.use_cases.UseCases
import com.practise.myonlinestore.domain.use_cases.login.LoginUseCases
import com.practise.myonlinestore.domain.use_cases.shop.ShopUseCases
import com.practise.myonlinestore.domain.use_cases.sign_up.SignUpUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSighUpRepository(): SignUpRepository {
        return SignUpRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideShopRepository(): ShopRepository {
        return ShopRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesUseCases(
        signUpRepository: SignUpRepository,
        loginRepository: LoginRepository,
        shopRepository: ShopRepository,
    ): UseCases =
        UseCases(
            signUp = SignUpUseCases(repository = signUpRepository),
            login = LoginUseCases(repository = loginRepository),
            shop = ShopUseCases(repository = shopRepository)
        )
}