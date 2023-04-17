package com.example.checkingproducts.ui.common

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkingproducts.R

@Composable
fun ArrowBackIcon(onBackClick: () -> Unit) {
    IconButton(
        onClick = onBackClick,
        modifier = Modifier.testTag(stringResource(id = R.string.arrowBackIcon_iconButton_test_TAG))
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(id = R.string.back_TEXT)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevArrowBackIconLightMode() {
    ArrowBackIcon(onBackClick = {})
}
