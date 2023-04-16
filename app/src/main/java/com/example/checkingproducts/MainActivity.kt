package com.example.checkingproducts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.checkingproducts.data.remote.utils.RemoteUtils.readMockedContent
import com.example.checkingproducts.ui.app.ProductsAppScreen
import com.example.checkingproducts.ui.navigation.MainScreenView
import com.example.checkingproducts.ui.screens.main.viewmodel.MainViewModel
import com.example.checkingproducts.ui.theme.CheckingProductsTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readMockedContent(this)
        setContent {
            ProductsAppScreen {
                MainScreenView()
            }
        }
    }
}
