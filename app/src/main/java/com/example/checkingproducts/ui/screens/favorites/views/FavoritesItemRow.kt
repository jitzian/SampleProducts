package com.example.checkingproducts.ui.screens.favorites.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.checkingproducts.R
import com.example.checkingproducts.data.db.entities.ProductEntityDB

@Composable
fun FavoritesItemsRow(data: ProductEntityDB, showFavoriteIcon: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .padding(
                horizontal = dimensionResource(id = R.dimen.dimen_16_dp),
                vertical = dimensionResource(id = R.dimen.dimen_8_dp)
            ),
        elevation = dimensionResource(id = R.dimen.dimen_4_dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.dimen_8_dp),
                        vertical = dimensionResource(id = R.dimen.dimen_8_dp)
                    ),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_8_dp))
            ) {
                Image(
                    painter = rememberImagePainter(data = data.url),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(140.dp)
                        .height(140.dp)
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dimen_8_dp)))
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(id = R.dimen.dimen_8_dp),
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (showFavoriteIcon) {
                            Icon(
                                imageVector = if (data.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = null
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = data.name,
                        style = MaterialTheme.typography.body1
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = data.current_value,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.dimen_8_dp),
                        end = dimensionResource(id = R.dimen.dimen_8_dp)
                    ),
                text = data.description,
                style = MaterialTheme.typography.body2
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = dimensionResource(id = R.dimen.dimen_8_dp)),
                text = data.terms,
                style = MaterialTheme.typography.overline
            )

        }
    }
}

@Preview
@Composable
fun PrevFavoritesIsFavItemsRow() {
    FavoritesItemsRow(
        data = ProductEntityDB(
            id = 110580,
            current_value = "\$0.75 Cash Back",
            description = "Any variety - 2 ct. pack or larger",
            name = "Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges",
            terms = "Rebate valid on Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges for any variety, 2 ct. pack or larger.",
            url = "https://product-images.ibotta.com/offer/OS0MnVcHXe7snozDC7nIiw-normal.png",
            isFavorite = false
        )
    )
}

@Preview
@Composable
fun PrevFavoritesIsNotFavItemsRow() {
    FavoritesItemsRow(
        data = ProductEntityDB(
            id = 110580,
            current_value = "\$0.75 Cash Back",
            description = "Any variety - 2 ct. pack or larger",
            name = "Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges",
            terms = "Rebate valid on Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges for any variety, 2 ct. pack or larger.",
            url = "https://product-images.ibotta.com/offer/OS0MnVcHXe7snozDC7nIiw-normal.png",
            isFavorite = true
        )
    )
}

@Preview
@Composable
fun PrevFavoritesIsFavItemsRowAndShowFav() {
    FavoritesItemsRow(
        data = ProductEntityDB(
            id = 110580,
            current_value = "\$0.75 Cash Back",
            description = "Any variety - 2 ct. pack or larger",
            name = "Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges",
            terms = "Rebate valid on Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges for any variety, 2 ct. pack or larger.",
            url = "https://product-images.ibotta.com/offer/OS0MnVcHXe7snozDC7nIiw-normal.png",
            isFavorite = false
        ),
        showFavoriteIcon = true
    )
}

@Preview
@Composable
fun PrevFavoritesIsNotFavItemsRowAndShowFav() {
    FavoritesItemsRow(
        data = ProductEntityDB(
            id = 110580,
            current_value = "\$0.75 Cash Back",
            description = "Any variety - 2 ct. pack or larger",
            name = "Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges",
            terms = "Rebate valid on Scotch-Brite® Scrub Dots Heavy Duty Scrub Sponges for any variety, 2 ct. pack or larger.",
            url = "https://product-images.ibotta.com/offer/OS0MnVcHXe7snozDC7nIiw-normal.png",
            isFavorite = true
        ),
        showFavoriteIcon = true
    )
}