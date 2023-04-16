package com.example.checkingproducts.ui.screens.detail.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.checkingproducts.R
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.ui.app.ProductsAppScreen
import com.example.checkingproducts.ui.common.MainTopBar
import com.example.checkingproducts.ui.screens.detail.viewmodel.DetailsViewModel
import com.example.checkingproducts.ui.screens.favorites.views.FavoritesItemsRow

@Composable
fun DetailsScreenState(
    id: String,
    onBackClick: () -> Unit,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val state = detailsViewModel.state.collectAsState()
    detailsViewModel.findProductByIdRoom(id.toInt())
    DetailsScreen(data = state.value.data, onBackClick = onBackClick)
}

@Composable
fun DetailsScreen(data: ProductEntityDB?, onBackClick: () -> Unit) {
    ProductsAppScreen {
        Scaffold(topBar = {
            MainTopBar(
                barTitle = "Details",
                showBackButton = true,
                onBackClick = onBackClick
            )
        }) {
            Box(modifier = Modifier.fillMaxSize()) {
                if (data != null) {
                    FavoritesItemsRow(data = data)
                } else {
                    Text(stringResource(id = R.string.there_is_no_data_TEXT))
                }
            }
        }
    }
}