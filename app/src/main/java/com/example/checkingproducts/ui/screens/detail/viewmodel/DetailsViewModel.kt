package com.example.checkingproducts.ui.screens.detail.viewmodel

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
class DetailsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    /**
     * Function that retrieves a product from DB by id [id]
     * */
    fun findProductByIdRoom(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.findProductByIdRoom(id).collect { product ->
            _state.value = UIState(product)
        }
    }

    //UIState
    data class UIState(val data: ProductEntityDB? = null)

}