package com.carolmusyoka.mercadeals.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.carolmusyoka.mercadeals.domain.model.AllProductsResponse
import com.carolmusyoka.mercadeals.domain.model.Product
import com.carolmusyoka.mercadeals.presentation.components.TopAppBarWithBack
import com.carolmusyoka.mercadeals.presentation.theme.*
import com.carolmusyoka.mercadeals.presentation.viewmodel.ProductViewModel


@Composable
fun ProductDetailScreen(
    navBack: () -> Unit,
    navigateToFavorite: () -> Unit,
    navToPlaceDetail: () -> Unit,
    productId: String,
    viewModel: ProductViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = {}
            )
        },
        backgroundColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = blueDark
            ){
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Add to cart",
                    tint = Color.White
                )
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ){
               ConstraintLayout {
                   val (imagesliderref, addtocartref) = createRefs()
                   Box(modifier =
                   Modifier
                       .height(280.dp)
                       .constrainAs(imagesliderref) {
                           top.linkTo(imagesliderref.top)
                           bottom.linkTo(imagesliderref.top)
                           start.linkTo(parent.start)
                           end.linkTo(parent.end)
                       }){

//                       ProductImage(product)
                   }
                   Surface(
                       color = Color.White,
                       shape = RoundedCornerShape(40.dp)
                           .copy(
                               bottomStart = ZeroCornerSize,
                               bottomEnd = ZeroCornerSize
                           ),
                       modifier = Modifier
                           .fillMaxSize()
                           .padding(top = 300.dp)
                           .constrainAs(addtocartref) {
                               bottom.linkTo(parent.bottom)
                               start.linkTo(parent.start)
                               end.linkTo(parent.end)
                           }
                   ) {
                       Column (
                           modifier = Modifier
                               .fillMaxSize()
                               .padding(30.dp)
                       ){
//                           ProductTitleAndPrice(product)
//                           Spacer(modifier = Modifier.padding(10.dp))
//                           RatingsAndNumberOfPeople(product)
//                           Spacer(modifier = Modifier.padding(10.dp))
//                           ProductDescription(product)
                       }
                       
                   }
               }
            }
        }
    )

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductImage(product: Product) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
         Image(
             painter = rememberImagePainter(product.image),
             contentDescription = "",
             modifier = Modifier
                 .size(250.dp)
         )
    }
}

@Composable
fun ProductTitleAndPrice(product: Product) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .height(4.dp)
                .width(40.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = product.title,
                color = titleTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Column(modifier = Modifier.wrapContentHeight()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                blueDark,
                                fontWeight = FontWeight.Bold
                            )
                        ){
                            append("$ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ){
                            // Product price
                            append(product.price.toString())
                        }
                    },
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                    fontSize = 16.sp
                )
            }

        }

    }
}


@Composable
fun RatingsAndNumberOfPeople(product: Product) {
    Column(modifier = Modifier.fillMaxWidth()){
        Text(
            text = "Product Ratings",
            color = titleTextColor,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            OutlinedButton(
                onClick = { /*TODO*/ },
                Modifier
                    .border(
                        color = Color.Transparent,
                        width = 1.dp
                    )
                    .background(color = Color.Transparent),
            ) {
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = null,
                    tint = yellowColor,
                    modifier = Modifier.padding(end = 4.dp)
                )
                // Populate the star rating
                Text(text = " ${product.rating.rate} Star Rating", color = Color.DarkGray)
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                Modifier
                    .border(
                        color = Color.Transparent,
                        width = 1.dp
                    )
                    .background(color = Color.Transparent),
            ) {
                Icon(
                    imageVector = Icons.Default.People,
                    contentDescription = null,
                    tint = darkgrey,
                    modifier = Modifier.padding(end = 4.dp)
                )
                //populate number of people who have rated this product
                Text(text = "${product.rating.count}", color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun ProductDescription(product: Product) {
   Column(modifier = Modifier.fillMaxWidth()) {
         Text(
              text = "Product Description",
              color = titleTextColor,
              fontSize = 18.sp,)

       Spacer(modifier = Modifier.padding(5.dp))

       Text(text = product.description,
                color = lightblack,
                fontSize = 14.sp)

   }
}
