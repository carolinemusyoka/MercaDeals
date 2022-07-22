package com.carolmusyoka.mercadeals.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay


@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun OnboardingScreen(navToSignUpScreen: () -> Unit, navToLoginScreen: () -> Unit) {
    Text(text = "Onboarding Screen")
    produceState(initialValue = -1){
        delay(1000)
        navToSignUpScreen()
    }
}