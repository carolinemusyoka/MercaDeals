package com.carolmusyoka.mercadeals.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.mercadeals.R
import kotlinx.coroutines.delay

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun SplashScreen(navToOnBoardingScreen: () -> Unit){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.shop),
                contentDescription = "Logo"
            )
        }
    }

    produceState(initialValue = -1) {
        delay(1000)
        navToOnBoardingScreen()
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    val navController = rememberNavController()
    SplashScreen(navToOnBoardingScreen = {  })
}