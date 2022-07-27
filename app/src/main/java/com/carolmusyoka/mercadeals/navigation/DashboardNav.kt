package com.carolmusyoka.mercadeals.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.mercadeals.presentation.MercaHomeDrawer
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable

fun DashboardNav(
    navToProductDetails: () -> Unit,
    navToCart: () -> Unit,
    navToBookmarks: () -> Unit,
    navToProfile: () -> Unit,
    modifier: Modifier = Modifier
){
    val tabs = remember{ HomeTabs.values()}
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Color.White,
        drawerBackgroundColor = Color.White,

        drawerContent = {
            MercaHomeDrawer(
                navToProfile = {/*TODO*/},
                navToSearch = {/*TODO*/}
            )
        },

        bottomBar = {
            MercaDealsBottomBar(
                tabs = tabs,
                navController = navController
            )}
    ) { innerPadding ->
        NavGraph(
            modifier = Modifier.padding(innerPadding),
            navController,
            openDrawer = { scope.launch{
            scaffoldState.drawerState.open()
        }}
        )
    }
}
