package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carolmusyoka.mercadeals.presentation.components.Menu


@Composable
fun SearchScreen(
    navBack:() -> Unit,
    navToProductDetail: () -> Unit,
    modifier: Modifier = Modifier
){
    Menu(
        title = "Search",
        pressBack = navBack)
    SearchField()

}

@Composable
fun SearchField() {

}
@Preview
@Composable
fun PreviewSearchScreen() {
    SearchScreen(
        navBack = {},
        navToProductDetail = {},
        modifier = Modifier
    )
}
