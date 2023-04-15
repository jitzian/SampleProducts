package com.example.checkingproducts.data.di.modules

import com.example.checkingproducts.data.domain.repository.products.ProductsRepository
import com.example.checkingproducts.data.repository.products.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductsRepositoryModule {

    @Binds
    @Singleton
    abstract fun productsRepository(productsRepository: ProductsRepositoryImpl): ProductsRepository
}