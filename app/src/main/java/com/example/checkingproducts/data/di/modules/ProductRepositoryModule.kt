package com.example.checkingproducts.data.di.modules

import com.example.checkingproducts.data.domain.repository.product.ProductRepository
import com.example.checkingproducts.data.repository.product.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepositoryModule {

    @Binds
    @Singleton
    abstract fun productRepository(productRepository: ProductRepositoryImpl): ProductRepository
}