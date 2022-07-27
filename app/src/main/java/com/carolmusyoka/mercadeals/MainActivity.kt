package com.carolmusyoka.mercadeals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.carolmusyoka.mercadeals.presentation.theme.MercaDealsTheme
import com.carolmusyoka.mercadeals.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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