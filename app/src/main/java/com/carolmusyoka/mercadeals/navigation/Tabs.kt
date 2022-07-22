package com.carolmusyoka.mercadeals.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.carolmusyoka.mercadeals.presentation.screens.FavoriteScreen
import com.carolmusyoka.mercadeals.presentation.screens.DashboardScreen
import com.carolmusyoka.mercadeals.presentation.screens.ProfileScreen

enum class HomeTabs(
    val title: String,
    val icon: ImageVector,
    val route: String
){
    HOME("Home", Icons.Rounded.Home, "tabs/home"),
    FAVORITES("Favorites", Icons.Rounded.Favorite, "tabs/bookmarks"),
    PROFILE("Settings", Icons.Rounded.Person, "tabs/profile")
}

fun NavGraphBuilder.addHomeGraph(
    navController: NavController,
    navToProductDetail: () -> Unit,
    modifier: Modifier = Modifier
){
    composable(HomeTabs.HOME.route){
        DashboardScreen(
            navToProfile = {navController.navigate(HomeTabs.PROFILE.route)},
            navToProductDetail = navToProductDetail,
            modifier = modifier
        )
    }
    composable(HomeTabs.FAVORITES.route){
        FavoriteScreen(
            navBack = { navController.navigateUp() },
            navToProductDetail = navToProductDetail,
            modifier = modifier
        )
    }
    composable(HomeTabs.PROFILE.route){
        ProfileScreen(
            navBack = { navController.navigateUp() },
            modifier = modifier
        )
    }
}

@Composable
fun MercaDealsBottomBar(
    navController: NavHostController,
    tabs: Array<HomeTabs>
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: HomeTabs.HOME.route

    val routes = remember { HomeTabs.values().map { it.route } }

    if (currentRoute in routes){
        BottomNavigation(backgroundColor = MaterialTheme.colors.surface) {
            tabs.forEach {  tab ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = tab.icon,contentDescription = tab.title) },
                    label = { Text(text = tab.title)},
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (currentRoute != tab.route) {
                            navController.navigate(tab.route)
                        }
                    },
                    alwaysShowLabel = false
                )

            }

        }
    }

}