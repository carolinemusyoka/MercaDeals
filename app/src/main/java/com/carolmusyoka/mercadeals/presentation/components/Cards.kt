package com.carolmusyoka.mercadeals.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.domain.model.Product
import com.carolmusyoka.mercadeals.domain.model.Rating
import com.carolmusyoka.mercadeals.navigation.DashDestinations
import com.carolmusyoka.mercadeals.presentation.theme.*

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun ProductCardItem(
    product: Product,
    navController: NavController,
){
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .padding(4.dp)
        ,
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
        onClick = {
            navController.navigate(DashDestinations.ProductDetail.createRoute(product.id.toString()))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ){
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = lightGrey
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    modifier = Modifier.height(100.dp),
                    contentScale = ContentScale.Inside,
                    // populate product image
                    painter = rememberImagePainter(product.image),
                    contentDescription = stringResource(R.string.app_name),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // product name
                if (product != null) {
                    Text(
                        text = product.title,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = titleTextColor
                    )
                }
                Spacer(modifier = Modifier.height(2.5.dp))
                if (product.rating.rate.toString() < 4.5.toString()){
                    Text(
                        text = "Trending",
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = blueDark,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                } else{
                    Text(
                        text = "Popular",
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        color = blueDark,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }


                // product price
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                blueDark,
                                fontWeight = FontWeight.Bold,
                            )
                        ){
                            append("$ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ){
                            //populate product price
                            append(product.price.toString())
                        }
                    },
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                    fontSize = 12.sp,
                )

            }

        }
    }
    Spacer(modifier = Modifier.width(16.dp))
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun SaveItemCard(
    product: Product,
    navProductDetail: () -> Unit
) {
    Card(
        onClick = {},
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(product.image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(width = 90.dp, height = 110.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                Text(text = product.title, style = MaterialTheme.typography.button, fontSize = 18.sp)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Rounded.Star,
                        contentDescription = null,
                        tint = orange,
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    Text(
                        text = product.rating.rate.toString(),
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    blueDark,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp
                                )
                            ){
                                append("$ ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    titleTextColor,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp
                                )
                            ){
                                //populate product price
                                append(product.price.toString())
                            }
                        },
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SaveItemPreview() {
    SaveItemCard(
        product = Product(
            category = "",
            description = "",
            id = 1,
            title = "Product 1",
            price = 100.00,
            image = "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
            rating = Rating(
                rate = 4.5,
                count = 10
            )
        ),
        navProductDetail = {}
    )
}

