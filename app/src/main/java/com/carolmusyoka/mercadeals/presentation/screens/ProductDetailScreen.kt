package com.carolmusyoka.mercadeals.presentation.screens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.carolmusyoka.mercadeals.domain.model.detailView.UiState
import com.carolmusyoka.mercadeals.presentation.components.TopAppBarWithBack
import com.carolmusyoka.mercadeals.presentation.theme.*
import com.carolmusyoka.mercadeals.presentation.viewmodel.ProductDetailViewModel


@Composable
fun ProductDetailScreen(
    navBack: () -> Unit,
    navigateToFavorite: () -> Unit,
    modifier: Modifier = Modifier,
    productId:String,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {

    val productDetail = remember{
        viewModel.getProductDetail(productId.toInt())
        viewModel.productDetail
    }.collectAsState()


    Scaffold(
        topBar = {
            TopAppBarWithBack(
                onBackClick = navBack,
            )
        },
        backgroundColor = Color.White,
        content = {
            val context = LocalContext.current
            when {
                productDetail.value.isLoading -> {

                }
                productDetail.value.data != null -> {
                    // Data
                    Log.d("TAG", "ProductDetailScreen: ${productDetail.value.data}")
                    val productsValue = productDetail.value
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

                                ProductImage(productsValue.data?.image ?: "")
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
                                    ProductTitleAndPrice(productsValue)
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    RatingsAndNumberOfPeople(productsValue)
                                    Spacer(modifier = Modifier.padding(10.dp))
                                    ProductDescription(productsValue)
                                }

                            }
                        }
                    }
                }
                else -> {
                    // Error
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    )

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductImage(imageUrl: String) {



    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
         Image(
             painter = rememberImagePainter(imageUrl),
             contentDescription = "",
             modifier = Modifier
                 .size(250.dp)
         )
    }
}

@Composable
fun ProductTitleAndPrice(product: UiState) {
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

        Column (
            modifier = Modifier.fillMaxWidth(),
        ){
            Text(
                text = product.data?.title ?: "",
                color = titleTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "$ ${product.data?.price ?: 0}",
                fontWeight = FontWeight.SemiBold,
                color = blueDark,
                fontSize = 16.sp,)

        }

    }
}


@Composable
fun RatingsAndNumberOfPeople(product: UiState) {
    Column(modifier = Modifier.fillMaxWidth()){
        Text(
            text = "Product Ratings",
            color = titleTextColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold)
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
                Text(text = " ${product.data?.rating?.rate} Star Rating", color = Color.DarkGray)
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
                Text(text = "${product.data?.rating?.count}", color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun ProductDescription(product: UiState) {
   Column(modifier = Modifier.fillMaxWidth()) {
         Text(
              text = "Product Description",
             color = titleTextColor,
             fontSize = 18.sp,
             fontWeight = FontWeight.SemiBold)

       Spacer(modifier = Modifier.padding(5.dp))

       Text(text = product.data?.description ?: "",
                color = lightblack,
                fontSize = 14.sp)

   }
}
