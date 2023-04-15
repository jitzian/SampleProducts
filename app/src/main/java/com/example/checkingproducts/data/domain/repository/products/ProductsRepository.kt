package com.example.checkingproducts.data.domain.repository.products

import com.example.checkingproducts.data.remote.model.ProductsItem

interface ProductsRepository {
    suspend fun getProducts(): List<ProductsItem>
}