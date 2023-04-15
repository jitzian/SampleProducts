package com.example.checkingproducts.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkingproducts.R
import com.example.checkingproducts.data.remote.model.ProductsItem

@Composable
fun RowItem(data: ProductsItem, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_16_dp),
                vertical = dimensionResource(id = R.dimen.dimen_8_dp)
            )
            .clickable {
                onItemClick.invoke()
            },
        elevation = dimensionResource(id = R.dimen.dimen_4_dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.dimen_8_dp),
                    top = dimensionResource(id = R.dimen.dimen_24_dp),
                    end = dimensionResource(id = R.dimen.dimen_8_dp)
                )
        ) {
            //ProductImage(name = data.name, url = data.url)
            ProductImage(name = data.name, url = data.url ?: "")
            Text(
                text = data.current_value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.dimen_8_dp)),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = data.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.dimen_8_dp)),
                style = MaterialTheme.typography.caption
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrevRowItem() {
    RowItem(
        data = ProductsItem(
            current_value = "\$0.75 Cash Back",
            description = "Any variety - 2 ct. pack or larger",
            id = "110579",
            name = "Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges",
            terms = "Rebate valid on Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges for any variety, 2 ct. pack or larger.",
            url = "https://product-images.ibotta.com/offer/dUxYcQPeq391-DiywFZF8g-normal.png"
        ),
        onItemClick = {}
    )
}