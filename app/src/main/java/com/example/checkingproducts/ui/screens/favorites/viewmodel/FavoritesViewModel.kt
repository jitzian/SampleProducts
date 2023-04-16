package com.example.checkingproducts.ui.screens.favorites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.data.domain.repository.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    /**
     * Function that retrieves all the favorite products from DB
     * */
    fun getFavorites() = viewModelScope.launch(Dispatchers.IO) {
        _state.value = UIState(true)
        productRepository.getAllFavoriteProductsRoom().collect { items ->
            _state.value = UIState(data = items)
        }
    }

    data class UIState(
        val isLoading: Boolean = false,
        val data: List<ProductEntityDB> = emptyList()
    )

}