package com.example.checkingproducts.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val title: String, val icon: ImageVector? = null, val route: String) {
    object MainNavScreen : Screens(
        title = "Main",
        icon = Icons.Default.Inbox,
        route = "main_screen"
    )

    object DetailsNavScreen : Screens(
        title = "Details",
        route = "details_screen"
    ) {
        const val id = "id"
    }

    object FavoritesNavScreen : Screens(
        title = "Favorites",
        icon = Icons.Default.Favorite,
        route = "favorites_screen"
    )

    // build navigation path (for screen navigation)
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    // build and setup route format (in navigation graph)
    fun withArgsFormat(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }

}