package com.example.checkingproducts.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "product")
data class ProductEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val current_value: String = "",
    val description: String = "",
    val name: String = "",
    val terms: String = "",
    val url: String = "",
    var isFavorite: Boolean = false
) : Parcelable