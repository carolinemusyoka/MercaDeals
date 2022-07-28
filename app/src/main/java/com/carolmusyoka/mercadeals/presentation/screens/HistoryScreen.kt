package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.presentation.components.Menu

@Composable
fun HistoryScreen(
    navBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Menu(
        title = "History",
        pressBack = navBack)
    LottieScreen()
}

@Composable
fun LottieScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.product_history))

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = Int.MAX_VALUE,
        isPlaying = true
    )
    Box(modifier = Modifier
        .padding(top = 200.dp)
        .fillMaxWidth()
        .height(400.dp)) {
        LottieAnimation(
            composition = composition,
            progress = progress,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHistoryScreen() {
    HistoryScreen(navBack = { })
}
