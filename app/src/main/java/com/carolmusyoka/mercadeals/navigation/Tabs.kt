package com.carolmusyoka.mercadeals.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
import com.carolmusyoka.mercadeals.presentation.screens.SearchScreen
import com.carolmusyoka.mercadeals.presentation.screens.DashboardScreen
import com.carolmusyoka.mercadeals.presentation.screens.HistoryScreen

enum class HomeTabs(
    val title: String,
    val icon: ImageVector,
    val route: String
){
    HOME("Home", Icons.Rounded.Home, "tabs/home"),
    SEARCH("Search", Icons.Rounded.Search, "tabs/search"),
    HISTORY("History", Icons.Rounded.History, "tabs/history")
}

fun NavGraphBuilder.addHomeGraph(
    navController: NavController,
    navToProductDetail: () -> Unit,
    openDrawer: () -> Unit,
    navToSearch: () -> Unit,
    modifier: Modifier = Modifier
){
    composable(HomeTabs.HOME.route){
        DashboardScreen(
            navToProfile = {navController.navigate(HomeTabs.HISTORY.route)},
            openDrawer = openDrawer,
            navToProductDetail = navToProductDetail,
            navToSearch = { navController.navigate(HomeTabs.SEARCH.route) },
            modifier = modifier
        )
    }
    composable(HomeTabs.SEARCH.route){
        SearchScreen(
            navBack = { navController.navigateUp() },
            navToProductDetail = navToProductDetail,
            modifier = modifier
        )
    }
    composable(HomeTabs.HISTORY.route){
        HistoryScreen(
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