package com.carolmusyoka.mercadeals

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.mercadeals.navigation.MainNavGraph
import com.carolmusyoka.mercadeals.presentation.theme.MercaDealsTheme
import com.carolmusyoka.mercadeals.presentation.viewmodel.ProductViewModel


@Composable
fun MercaDealsApp(){
    MercaDealsTheme {
        val navController = rememberNavController()

        MainNavGraph(
            navController = navController
        )
    }
}
