package com.carolmusyoka.mercadeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carolmusyoka.mercadeals.presentation.screens.DashboardScreen
import com.carolmusyoka.mercadeals.presentation.screens.SplashScreen
import com.carolmusyoka.mercadeals.presentation.theme.MercaDealsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercaDealsTheme {
                MercaDealsApp()
            }
        }
    }
}