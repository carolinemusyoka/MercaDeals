package com.carolmusyoka.mercadeals.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.presentation.theme.blueDark

@Composable
fun CustomTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier
                .width(50.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = ""
                )
            }
        }
        Card(
            modifier = Modifier
                .size(50.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(12.dp),
            backgroundColor = Color.Black
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = "User",
                modifier = Modifier.size(50.dp),
            )
        }

    }
}

@Composable
fun TopAppBarWithBack(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 5.dp
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = ""
                )
            }

        }

        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 5.dp
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "",
                    tint = blueDark
                )
            }

        }
    }
}

@Preview
@Composable
fun CustomTopBarPreview() {
    CustomTopBar()
}

@Preview
@Composable
fun TopAppBarWithBackPreview() {
    val onBackClick: () -> Unit = { }
    TopAppBarWithBack(onBackClick)
}