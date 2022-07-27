package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.carolmusyoka.mercadeals.presentation.components.GradientButton
import com.carolmusyoka.mercadeals.presentation.components.TransparentButton
import com.carolmusyoka.mercadeals.presentation.theme.blueDark
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.presentation.theme.background


@OptIn(ExperimentalUnitApi::class)
@Composable
fun LoginScreen(
    navToSignUpScreen: () -> Unit,
    navToForgotPasswordScreen: () -> Unit,
    navToHomeScreen: () -> Unit
    ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(16.dp)
        ) {
        Text(
            text = "Login to your account",
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(24f, TextUnitType.Sp),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp))
        Text(
            text = "Good to see you again, enter your details below to continue checking out our products.",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp)
            )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            OutlinedTextField(
                value = email,
                shape = RoundedCornerShape(16.dp),
                onValueChange = { s ->
                    email = s },
                label = {
                    Text("Email") },
                placeholder = {
                    Text("example@carolmusyoka.com")
                    },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp)
                )

                // Password text field
            OutlinedTextField(
                value = password,
                shape = RoundedCornerShape(16.dp),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                onValueChange = { s ->
                    password = s },
                label = {
                    Text("Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null)
                              },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                        Icon(
                            painter = run {
                                if (passwordVisibility) painterResource(id = R.drawable.ic_visibility_off)
                                else painterResource(id = R.drawable.ic_visibility)
                                },
                            contentDescription = null
                            )
                        }
                    },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                )
            TransparentButton(
                indication = rememberRipple(color = background),
                onClick = {
                    navToForgotPasswordScreen()
                    },
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 8.dp, top = 8.dp)
                ) {
                Text(
                    text = "Forgot password",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    color = blueDark,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
                // Create an account button
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
                          navToHomeScreen()
                    },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 24.dp, end = 24.dp, bottom = 8.dp)
                ) { Text(
                text = "Log in to my account",
                fontSize = TextUnit(14f, TextUnitType.Sp),
                color = Color.White,
                fontWeight = FontWeight.Bold
                    )
                }
                // Login to my account button
            TransparentButton(
                indication = rememberRipple(color = background),
                onClick = {
                    },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 24.dp, end = 24.dp)
                ) {
                Text(
                    text = "Create account",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    color = blueDark,
                    fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        navToSignUpScreen = {},
        navToForgotPasswordScreen = {},
        navToHomeScreen = {}
    )
}