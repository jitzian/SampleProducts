package com.example.checkingproducts.data.domain.repository.product

import com.example.checkingproducts.data.db.entities.ProductEntityDB
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun addProductRoom(product: ProductEntityDB)
    fun findProductByIdRoom(id: Int): Flow<ProductEntityDB>
    fun getAllProductsRoom(): Flow<List<ProductEntityDB>>
    fun getAllFavoriteProductsRoom(): Flow<List<ProductEntityDB>>
    suspend fun updateProductRoom(product: ProductEntityDB)
    suspend fun deleteProductRoom(product: ProductEntityDB)
}