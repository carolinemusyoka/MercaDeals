package com.carolmusyoka.mercadeals.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.carolmusyoka.mercadeals.R

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MercaHomeDrawer(navToProfile: () -> Unit, navToSearch: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column {

            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(142.dp)
                    .padding(top = 32.dp, start = 32.dp, end = 32.dp, bottom = 24.dp)
            )

            Text(
                text = "Carol Musyoka",
                color = Color.Black.copy(alpha = 0.8f),
                fontWeight = FontWeight.Bold,
                fontSize = TextUnit(16f, TextUnitType.Sp),
                modifier = Modifier
                    .padding(start = 24.dp)
            )

            Text(
                text = "carolmusyoka127@gmail.com",
                color = Color.Black.copy(alpha = 0.8f),
                fontWeight = FontWeight.Normal,
                fontSize = TextUnit(14f, TextUnitType.Sp),
                modifier = Modifier
                    .padding(start = 24.dp, top = 8.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 24.dp, top = 32.dp)
            ) {
                Drawer.values.forEach { drawer ->
                    DrawerItem(
                        drawer = drawer,
                        onClick = {}
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DrawerItem(
    drawer: Drawer,
    paddingValues: PaddingValues = PaddingValues(top = 12.dp, bottom = 12.dp),
    onClick: () -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding(),
                start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
            )
    ) {

        Icon(
            drawer.icon,
            tint = Color.Black,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )

        Text(
            text = drawer.name,
            color = Color.Black.copy(alpha = 0.8f),
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewDrawerItem(){
    Column {
        Drawer.values.forEach { drawer ->
            DrawerItem(
                drawer = drawer,
                onClick = {}
            )
        }
    }
}

data class Drawer(
    val name: String,
    val icon: ImageVector
) {
    companion object{
        val values = listOf(
            Drawer(
                name = "My profile",
                icon = Icons.Rounded.Person
            ),
            Drawer(
                name = "Payment method",
                icon = Icons.Rounded.Payment
            ),
            Drawer(
                name = "Settings",
                icon = Icons.Rounded.Settings
            ),
            Drawer(
                name = "Help",
                icon = Icons.Rounded.Help
            ),
            Drawer(
                name = "Privacy policy",
                icon = Icons.Rounded.PrivacyTip
            ),
        )
    }

}
