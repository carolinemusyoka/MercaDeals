package com.carolmusyoka.mercadeals.presentation.screens

import android.widget.Toast
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
import com.carolmusyoka.mercadeals.presentation.theme.background
import com.carolmusyoka.mercadeals.presentation.theme.orange
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.presentation.theme.blueDark


@OptIn(ExperimentalUnitApi::class)
@Composable
fun RegistrationScreen(navToSignInScreen:() -> Unit, navToLoginScreen:() -> Unit, navToHomeScreen: () -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "Create an account",
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(24f, TextUnitType.Sp),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
        )
        Text(
            text = "Hello there, enter your details so lets get started in ordering products online.",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Email text field
            OutlinedTextField(
                value = email,
                shape = RoundedCornerShape(16.dp),
                onValueChange = { s ->
                    email = s
                },
                label = {
                    Text("Email")
                },
                placeholder = {
                    Text("example@carolmusyoka.com")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null
                    )
                },
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
                    password = s
                },
                label = {
                    Text("Password")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibility = !passwordVisibility
                        }
                    ) {
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


            // Confirm password text field
            OutlinedTextField(
                value = confirmPassword,
                shape = RoundedCornerShape(16.dp),
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                onValueChange = { s ->
                    confirmPassword = s
                },
                label = {
                    Text("Confirm Password")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            confirmPasswordVisibility = !confirmPasswordVisibility
                        }
                    ) {
                        Icon(
                            painter = run {
                                if (confirmPasswordVisibility) painterResource(id = R.drawable.ic_visibility_off)
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
            ) {
                Text(
                    text = "Create an account",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            // Login to my account button
            TransparentButton(
                indication = rememberRipple(color = background),
                onClick = {
                    navToLoginScreen()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 24.dp, end = 24.dp)
            ) {
                Text(
                    text = "Login to my account",
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
fun SignUpScreenPreview() {
    RegistrationScreen(
        navToHomeScreen = {},
        navToLoginScreen = {},
        navToSignInScreen = {}
    )
}
