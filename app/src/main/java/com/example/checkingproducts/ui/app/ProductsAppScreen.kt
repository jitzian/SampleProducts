package com.example.checkingproducts.ui.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.checkingproducts.ui.theme.CheckingProductsTheme

@Composable
fun ProductsAppScreen(content: @Composable () -> Unit) {
    CheckingProductsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }

}