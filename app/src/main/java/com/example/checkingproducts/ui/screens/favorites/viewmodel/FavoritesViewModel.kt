package com.example.checkingproducts.ui.screens.favorites.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.data.domain.repository.product.ProductRepository
import com.example.checkingproducts.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    init {
        //getFavorites()
    }

    fun getFavorites() = viewModelScope.launch(Dispatchers.IO) {
        _state.value = UIState(true)
        //delay(2.seconds)
        //productRepository.getAllFavoriteProductsRoom().collect { items ->
        productRepository.getAllProductsRoom().collect { items ->
            Log.e(this@FavoritesViewModel.TAG(), "getFavorites: >> $items")
            _state.value = UIState(data = items)
        }
    }

    data class UIState(
        val isLoading: Boolean = false,
        val data: List<ProductEntityDB> = emptyList()
    )

}