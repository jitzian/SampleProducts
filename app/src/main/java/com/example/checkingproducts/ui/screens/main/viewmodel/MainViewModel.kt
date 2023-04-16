package com.example.checkingproducts.ui.screens.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.checkingproducts.data.domain.repository.product.ProductRepository
import com.example.checkingproducts.data.domain.repository.services.offline.toProductEntityDB
import com.example.checkingproducts.data.remote.model.ProductsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    /**
     * Function that retrieves data from "API" (fake) and it also inserts the data in DB
     * */
    private fun getProducts() = viewModelScope.launch(Dispatchers.IO) {
        _state.value = UIState(true)
        //Used to show the loading screen
        delay(2.seconds)
        val remoteProducts = productRepository.getProducts()
        if (remoteProducts.isNotEmpty()) {
            remoteProducts.forEach { product ->
                productRepository.addProductRoom(product.toProductEntityDB())
            }
            _state.value = UIState(data = remoteProducts)
        }
    }

    //UIState used to manage the data in UI level
    data class UIState(
        val isLoading: Boolean = false,
        val data: List<ProductsItem> = emptyList()
    )

}