package com.example.checkingproducts.ui.common

import android.util.Log
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkingproducts.R
import com.example.checkingproducts.data.db.entities.ProductEntityDB
import com.example.checkingproducts.data.remote.model.ProductsItem

@Composable
//fun RowItem(data: ProductsItem, onItemClick: (Int) -> Unit) {
fun RowItem(
    data: ProductEntityDB,
    onItemClick: (Int) -> Unit,
    updateProduct: (ProductEntityDB) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_16_dp),
                vertical = dimensionResource(id = R.dimen.dimen_8_dp)
            )
            .clickable {
                onItemClick.invoke(data.id)
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
            ProductImage(name = data.name, url = data.url)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.dimen_8_dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.current_value,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = if (data.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    modifier = Modifier.clickable {
                        Log.e("RowItem", "RowItem: ${data.name}, ${data.isFavorite}")
                        //TODO: Implement update of the favorite field in DB
                        updateProduct.invoke(data)
                    },
                    contentDescription = if (data.isFavorite) {
                        stringResource(id = R.string.favorite_TEXT)
                    } else stringResource(
                        id = R.string.not_favorite_TEXT
                    ),
                )
            }
            Text(
                text = data.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.dimen_8_dp)),
                style = MaterialTheme.typography.overline,
                maxLines = 1
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrevRowItem() {
    RowItem(
        //data = ProductsItem(
        data = ProductEntityDB(
            current_value = "\$0.75 Cash Back",
            description = "Any variety - 2 ct. pack or larger",
            id = 110579,
            name = "Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges",
            terms = "Rebate valid on Scotch-Brite® Scrub Dots Non-Scratch Scrub Sponges for any variety, 2 ct. pack or larger.",
            url = "https://product-images.ibotta.com/offer/dUxYcQPeq391-DiywFZF8g-normal.png"
        ),
        onItemClick = {},
        updateProduct = {}
    )
}