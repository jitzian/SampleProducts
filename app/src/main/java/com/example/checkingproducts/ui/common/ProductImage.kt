package com.example.checkingproducts.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.example.checkingproducts.R

@Composable
fun ProductImage(url: String, name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Image(
            painter = rememberImagePainter(data = url),
            contentDescription = name,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.dimen_6_dp))
                .aspectRatio(1f)
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_4_dp)))
        )
    }
}

@Preview
@Composable
fun ProductImage() {
    ProductImage(
        url = "https://product-images.ibotta.com/offer/dUxYcQPeq391-DiywFZF8g-normal.png",
        name = "Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges"
    )
}