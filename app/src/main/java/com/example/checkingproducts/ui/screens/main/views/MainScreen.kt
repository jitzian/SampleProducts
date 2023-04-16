package com.example.checkingproducts.ui.screens.main.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.checkingproducts.R
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.ui.app.ProductsAppScreen
import com.example.checkingproducts.ui.common.LoadingScreen
import com.example.checkingproducts.ui.common.MainTopBar
import com.example.checkingproducts.ui.common.RowItem
import com.example.checkingproducts.ui.screens.main.viewmodel.MainViewModel

@ExperimentalFoundationApi
@Composable
fun MainScreenState(
    navigateToDetails: (Int) -> Unit,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val state by mainViewModel.state.collectAsState()
    if (state.isLoading) {
        LoadingScreen()
    } else {
        MainScreen(data = state.data, navigateToDetails = navigateToDetails)
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen(data: List<ProductEntityDB>, navigateToDetails: (Int) -> Unit) {

    val state = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    ProductsAppScreen {
        Scaffold(
            topBar = { MainTopBar(barTitle = stringResource(id = R.string.products_TEXT)) }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    state = state,
                    cells = GridCells.Adaptive(180.dp),
                    contentPadding = PaddingValues(4.dp)
                ) {
                    items(data) { item ->
                        RowItem(data = item, onItemClick = navigateToDetails)
                    }
                }
            }
        }
    }
}