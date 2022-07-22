package com.carolmusyoka.mercadeals.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.carolmusyoka.mercadeals.navigation.DashDestinations.PRODUCT_DETAIL_ID
import com.carolmusyoka.mercadeals.navigation.DashDestinations.PRODUCT_DETAIL_ROUTE
import com.carolmusyoka.mercadeals.presentation.screens.ProductDetailScreen

object DashDestinations {
    const val HOME_ROUTE = "home"
    const val PRODUCT_DETAIL_ROUTE = "place"
    const val PRODUCT_DETAIL_ID = "productId"
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = DashDestinations.HOME_ROUTE
) {
    val actions = remember { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(
            route = DashDestinations.HOME_ROUTE,
            startDestination = HomeTabs.HOME.route
        ) {
            addHomeGraph(
                navController = navController,
                navToProductDetail = { actions.navigateToPlaceDetail("temp") },
                modifier = modifier
            )
        }
        composable(
            route = "$PRODUCT_DETAIL_ROUTE/{$PRODUCT_DETAIL_ID}",
            arguments = listOf(
                navArgument(PRODUCT_DETAIL_ID) { type = NavType.StringType }
            )
        ) {
            ProductDetailScreen(
                navBack = { navController.navigateUp() },
                navigateToFavorite = { navController.navigate(HomeTabs.FAVORITES.route) },
                modifier = modifier,
                navToPlaceDetail = { actions.navigateToPlaceDetail("temp") }
            )
        }
    }
}

class MainActions(navController: NavHostController) {

    val popBackStack: () -> Unit = { navController.popBackStack() }
    val upPress: () -> Unit = { navController.navigateUp() }


    val goToHome: () -> Unit = {
        navController.popBackStack()
        navController.navigate(HomeTabs.HOME.route)
    }
    val navigateToPlaceDetail = { placeId: String ->
        navController.navigate(route = "$PRODUCT_DETAIL_ROUTE/$placeId")
    }
}