package com.example.checkingproducts.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduct(product: ProductEntityDB)

    @Query("SELECT * FROM product WHERE id = :id")
    fun findProductById(id: Int): Flow<ProductEntityDB>

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<ProductEntityDB>>

    @Query("SELECT * FROM product WHERE isFavorite = 1")
    fun getAllFavoriteProducts(): Flow<List<ProductEntityDB>>

    @Update
    suspend fun updateProduct(product: ProductEntityDB)

    @Delete
    suspend fun deleteProduct(product: ProductEntityDB)

}