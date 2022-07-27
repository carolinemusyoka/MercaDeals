package com.carolmusyoka.mercadeals.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carolmusyoka.mercadeals.presentation.screens.LoginScreen
import com.carolmusyoka.mercadeals.presentation.screens.OnboardingScreen
import com.carolmusyoka.mercadeals.presentation.screens.RegistrationScreen
import com.carolmusyoka.mercadeals.presentation.screens.SplashScreen

// this will cater for the splash screen , login, etc
object MainDestination {
    const val SPLASH = "splash"
}
enum class MainScreen(
    val route: String
){
    SPLASH("splash"),
    ONBOARDING("onboarding"),
    LOGIN("login"),
    SIGNUP("signup"),
    HOME("home")
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestination.SPLASH
){
   val actions = remember { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = MainScreen.SPLASH.route
    ){
        composable(
            route = MainScreen.SPLASH.route,
        ){
            SplashScreen(navToOnBoardingScreen = {navController.navigate(MainScreen.ONBOARDING.route)})
        }
        composable(
            route = MainScreen.ONBOARDING.route,
        ){
            OnboardingScreen(
                navToSignUpScreen = {navController.navigate(MainScreen.SIGNUP.route)},
                navToLoginScreen = {navController.navigate(MainScreen.LOGIN.route)},
                navToHomeScreen = {navController.navigate(DashDestinations.HOME_ROUTE)}
            )
        }
        composable(
            route = MainScreen.SIGNUP.route,
        ){
            RegistrationScreen(
                navToSignInScreen = {navController.navigate(MainScreen.SIGNUP.route)},
                navToLoginScreen = {navController.navigate(MainScreen.LOGIN.route)},
                navToHomeScreen = {navController.navigate(DashDestinations.HOME_ROUTE)})
        }
        composable(
            route = MainScreen.LOGIN.route,
        ){
            LoginScreen(
                navToSignUpScreen = {navController.navigate(DashDestinations.HOME_ROUTE)},
                navToForgotPasswordScreen = {navController.navigate(DashDestinations.HOME_ROUTE)},
                navToHomeScreen = {navController.navigate(DashDestinations.HOME_ROUTE)})
        }
        composable(
            route = MainScreen.HOME.route,
        ){
            DashboardNav(
                navToProductDetails = {/*TODO*/},
                navToCart = {/*TODO*/},
                navToBookmarks = {/*TODO*/},
                navToProfile = {/*TODO*/},
                modifier
            )
        }
    }

}
