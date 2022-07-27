package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carolmusyoka.mercadeals.presentation.components.Menu

@Composable
fun HistoryScreen(
    navBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Menu(
        title = "History",
        pressBack = navBack)
}


@Preview
@Composable
fun PreviewHistoryScreen() {
    HistoryScreen(navBack = { })
}
