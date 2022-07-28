package com.carolmusyoka.mercadeals.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.carolmusyoka.mercadeals.presentation.screens.ProductDetailScreen

sealed class DashDestinations(val route: String) {
    object HomeRoute: DashDestinations("home")
    object  ProductDetail: DashDestinations("{productId}/detail")

    fun createRoute(productId: String) = "$productId/detail"
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = DashDestinations.HomeRoute.route,
    openDrawer: () -> Unit,

    ) {
    val actions = remember { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        navigation(
            route = DashDestinations.HomeRoute.route,
            startDestination = HomeTabs.HOME.route
        ) {
            addHomeGraph(
                navController = navController,
                navToProductDetail = {  },
                openDrawer = openDrawer,
                navToSearch = { navController.navigate(HomeTabs.SEARCH.route)},
                modifier = modifier,
            )
        }
        composable(
            route = DashDestinations.ProductDetail.route,

        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            Log.d("TAG", "NavGraph: productId: $productId")
            ProductDetailScreen(
                navBack = { navController.navigateUp() },
                navigateToFavorite = { navController.navigate(HomeTabs.SEARCH.route) },
                modifier = modifier,
                productId = productId,
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
    val navigateToProductDetail = { productId: String ->
        navController.navigate(DashDestinations.ProductDetail.createRoute(productId))
    }
}