package com.example.checkingproducts.data.repository.product

import android.app.Application
import com.example.checkingproducts.data.db.ProductsDB
import com.example.checkingproducts.data.db.dao.ProductDao
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.data.domain.repository.product.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(context: Application) : ProductRepository {

    private val db = ProductsDB.getInstance(context)
    private var productDao: ProductDao = db.productDao()
    override suspend fun addProductRoom(product: ProductEntityDB) = productDao.addProduct(product)

    override fun findProductByIdRoom(id: Int) = productDao.findProductById(id)

    override fun getAllProductsRoom() = productDao.getAllProducts()

    override fun getAllFavoriteProductsRoom() = productDao.getAllFavoriteProducts()

    override suspend fun updateProductRoom(product: ProductEntityDB) =
        productDao.updateProduct(product)

    override suspend fun deleteProductRoom(product: ProductEntityDB) =
        productDao.deleteProduct(product)
}