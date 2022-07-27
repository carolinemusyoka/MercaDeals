package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.animation.core.animate
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.presentation.components.GradientButton
import com.carolmusyoka.mercadeals.presentation.components.TransparentButton
import com.carolmusyoka.mercadeals.presentation.theme.background
import com.carolmusyoka.mercadeals.presentation.theme.blueDark
import com.carolmusyoka.mercadeals.presentation.theme.orange
import com.google.accompanist.pager.HorizontalPagerIndicator


@OptIn(ExperimentalPagerApi::class,
      ExperimentalUnitApi::class,
      ExperimentalFoundationApi::class)

@Composable
fun OnboardingScreen(navToSignUpScreen: () -> Unit, navToLoginScreen: () -> Unit, navToHomeScreen: () -> Unit) {
    val pagerState = rememberPagerState()
 // multiple lottie files

// create lottie composition spec for 3 lottie files
    val compositionOne by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.shopping_swipe_blue))
    val compositionTwo by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.add_to_cart_blue))
    val compositionThree by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.delivery_blue))

    val progressOne by animateLottieCompositionAsState(
        composition = compositionOne,
        iterations = Int.MAX_VALUE,
        isPlaying = true
    )
    val progressTwo by animateLottieCompositionAsState(
        composition = compositionTwo,
        iterations = Int.MAX_VALUE,
        isPlaying = true
    )
    val progressThree by animateLottieCompositionAsState(
        composition = compositionThree,
        iterations = Int.MAX_VALUE,
        isPlaying = true
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Text(
            text = when (pagerState.currentPage) {
                0 -> "Order your favourite products from trusted vendors"
                1 -> "Choose from a wide range of categories and products"
                2 -> "Enjoy instant delivery and payment across different options"
                else -> "Choose from a wide range of categories and products"
            },
            fontSize = TextUnit(24f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
        )

        CompositionLocalProvider(
            LocalOverScrollConfiguration provides null  // Remove over scroll effect
        ) {
            HorizontalPager(
                state = pagerState,
                count = 3,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) { page ->
                when(page){
                    0 -> LottieAnimation(
                        composition = compositionOne,
                        progress = progressOne,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                            .height(400.dp)
                    )
                    1 -> LottieAnimation(
                        composition = compositionTwo,
                        progress = progressTwo,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                            .height(400.dp)
                    )
                    2 -> LottieAnimation(
                        composition = compositionThree,
                        progress = progressThree,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                            .height(400.dp)
                    )
                    else ->{
                        LottieAnimation(
                            composition = compositionOne,
                            progress = progressOne,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                                .height(400.dp)
                        )
                    }
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        GradientButton(
            shape = RoundedCornerShape(18.dp),
            contentPadding = PaddingValues(),
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFF004b93),
                    Color(0xFFa7d4ff),
                )
            ),
            onClick = {
                navToSignUpScreen()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
        ) {
            Text(
                text = "Create an account",
                fontSize = TextUnit(14f, TextUnitType.Sp),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        TransparentButton(
            indication = rememberRipple(color = background),
            onClick = {
               navToLoginScreen()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
        ) {
            Text(
                text = "Login",
                fontSize = TextUnit(14f, TextUnitType.Sp),
                color = blueDark,
                fontWeight = FontWeight.Bold
            )
        }

        TransparentButton(
            indication = rememberRipple(color = background),
            onClick = {
                navToHomeScreen()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
        ) {
            Text(
                text = "Continue as guest",
                fontSize = TextUnit(14f, TextUnitType.Sp),
                color = blueDark,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(navToSignUpScreen = {}, navToLoginScreen = {}, navToHomeScreen = {})
}
