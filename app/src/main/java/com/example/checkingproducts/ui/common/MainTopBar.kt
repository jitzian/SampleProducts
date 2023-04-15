package com.example.checkingproducts.ui.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainTopBar(
    showBackButton: Boolean = false,
    barTitle: String? = null,
    onBackClick: (() -> Unit)? = null
) {
    if (showBackButton && onBackClick != null) {
        TopAppBar(
            title = {
                Text(text = barTitle?.takeIf { it.isNotEmpty() } ?: "")
            },
            navigationIcon = {
                ArrowBackIcon(onBackClick = onBackClick)
            }
        )
    } else {
        TopAppBar(
            title = { Text(text = barTitle?.takeIf { it.isNotEmpty() } ?: "") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevMainTopBarShowBackButton() {
    MainTopBar(
        showBackButton = true,
        barTitle = "Title",
        onBackClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PrevMainTopBarNoBackButton() {
    MainTopBar(barTitle = "Title")
}
