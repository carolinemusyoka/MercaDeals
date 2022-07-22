package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DashboardScreen(
    navToProfile:() -> Unit,
    navToProductDetail:() -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column (
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)){

        Text(text = "Dashhhhhhhhhhhhh" )
        //Custom topbar? or just a header?

        // Search Section - Search bar, filter, etc.

        // Recent Searches Section - Recent searches, etc.

    }


}