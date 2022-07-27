package com.carolmusyoka.mercadeals.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.carolmusyoka.mercadeals.R
import com.carolmusyoka.mercadeals.domain.model.Product
import com.carolmusyoka.mercadeals.domain.model.Rating
import com.carolmusyoka.mercadeals.domain.model.UiState
import com.carolmusyoka.mercadeals.presentation.theme.blueDark
import com.carolmusyoka.mercadeals.presentation.theme.lightGrey
import com.carolmusyoka.mercadeals.presentation.theme.titleTextColor

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun ProductCardItem(product: Product,
                    navPlaceDetail: () -> Unit ){
    val product = product
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
        onClick = navPlaceDetail
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
                if (product?.rating?.rate!! < 4.5){
                    Text(
                        text = "Trending",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
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

@Preview(showBackground = true)
@Composable
fun ProductCardItemPreview() {
    ProductCardItem(
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
        navPlaceDetail = { }
    )
}

