package com.example.checkingproducts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.checkingproducts.data.remote.utils.RemoteUtils.readMockedContent
import com.example.checkingproducts.ui.app.ProductsAppScreen
import com.example.checkingproducts.ui.navigation.MainScreenView
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
