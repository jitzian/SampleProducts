package com.example.checkingproducts.data.remote.model

data class ProductsItem(
    val current_value: String = "",
    val description: String = "",
    val id: String,
    val name: String = "",
    val terms: String = "",
    val url: String? = "https://upload.wikimedia.org/wikipedia/commons/0/0a/No-image-available.png"
)