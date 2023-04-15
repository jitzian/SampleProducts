package com.example.checkingproducts.data.domain.repository.services.offline

import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.data.remote.model.ProductsItem

fun ProductsItem.toProductEntityDB(): ProductEntityDB = ProductEntityDB(
    id = id.toInt(),
    url = url ?: "https://upload.wikimedia.org/wikipedia/commons/0/0a/No-image-available.png",
    name = name,
    description = description,
    terms = terms,
    current_value = current_value,
    isFavorite = false
)