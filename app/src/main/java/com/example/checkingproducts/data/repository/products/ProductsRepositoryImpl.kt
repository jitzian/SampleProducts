package com.example.checkingproducts.data.repository.products

import com.example.checkingproducts.data.domain.repository.products.ProductsRepository
import com.example.checkingproducts.data.remote.RestApi
import com.example.checkingproducts.data.remote.model.ProductsItem
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val restApi: RestApi
) : ProductsRepository {
    override suspend fun getProducts(): List<ProductsItem> {
        return restApi.getProducts()
    }
}