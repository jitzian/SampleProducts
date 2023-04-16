package com.example.checkingproducts.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.checkingproducts.ui.screens.detail.views.DetailsScreenState
import com.example.checkingproducts.ui.screens.favorites.views.FavoritesScreenState
import com.example.checkingproducts.ui.screens.main.views.MainScreenState

@ExperimentalFoundationApi
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainNavScreen.route
    ) {
        addMainScreen(navController, this)
        addFavoritesScreen(navController, this)
        addDetailsScreen(navController, this)
    }
}

@ExperimentalFoundationApi
private fun addMainScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = Screens.MainNavScreen.route) {
        MainScreenState(
            navigateToDetails = { id ->
                navController.navigate(Screens.DetailsNavScreen.withArgs(id.toString()))
            }
        )
    }
}

private fun addFavoritesScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = Screens.FavoritesNavScreen.route) {
        FavoritesScreenState()
    }
}


private fun addDetailsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = Screens.DetailsNavScreen.withArgsFormat(
            Screens.DetailsNavScreen.id
        ),
        arguments = listOf(
            navArgument(Screens.DetailsNavScreen.id) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments
        DetailsScreenState(
            onBackClick = {
                navController.popBackStack()
            },
            id = args?.getString(Screens.DetailsNavScreen.id) ?: "0"
        )
    }
}