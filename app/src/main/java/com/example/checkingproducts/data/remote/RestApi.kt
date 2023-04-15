package com.example.checkingproducts.data.remote

import com.example.checkingproducts.data.remote.model.ProductsItem
import retrofit2.http.GET
import retrofit2.http.Headers

interface RestApi {
    @Headers("mock: true")
    @GET("products")
    suspend fun getProducts(): List<ProductsItem>
}