package com.example.checkingproducts.ui.screens.favorites.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.ui.app.ProductsAppScreen
import com.example.checkingproducts.ui.common.LoadingScreen
import com.example.checkingproducts.ui.common.MainTopBar
import com.example.checkingproducts.ui.screens.favorites.viewmodel.FavoritesViewModel

@Composable
fun FavoritesScreenState(favoritesViewModel: FavoritesViewModel = hiltViewModel()) {
    val state by favoritesViewModel.state.collectAsState()
    favoritesViewModel.getFavorites()
    if (state.isLoading) {
        LoadingScreen()
    } else {
        FavoritesScreen(data = state.data)
    }

}

@Composable
fun FavoritesScreen(data: List<ProductEntityDB>) {
    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    ProductsAppScreen {
        Scaffold(topBar = {
            MainTopBar(barTitle = "Favorites")
        }) {
            LazyColumn(state = state) {
                items(data) { item ->
                    FavoritesItemsRow(data = item)
                }
            }
            //ScrollFloatingButton(state = state, coroutineScope = coroutineScope, data = data)
        }
    }

}