package com.carolmusyoka.mercadeals.presentation.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.carolmusyoka.mercadeals.domain.model.UiState
import com.carolmusyoka.mercadeals.presentation.components.CustomTopBar
import com.carolmusyoka.mercadeals.presentation.components.ProductCardItem
import com.carolmusyoka.mercadeals.presentation.components.Title
import com.carolmusyoka.mercadeals.presentation.theme.*
import com.carolmusyoka.mercadeals.presentation.viewmodel.ProductViewModel


@Composable
fun DashboardScreen(
    navToProfile:() -> Unit,
    openDrawer:() -> Unit,
    navToProductDetail:() -> Unit,
    navToSearch:() -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val products = remember {
          viewModel.getProducts()
          viewModel.products
    }.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ){
        val context = LocalContext.current
        Column(modifier = Modifier.padding(30.dp)){
            // Custom TopBar goes here
            CustomTopBar(openDrawer)
            // Have this spacing for each section
            Spacer(modifier = Modifier.padding(10.dp))
            //Search Section
            ProductsSearch(navToSearch)

            Spacer(modifier = Modifier.height(24.dp))

            ProductList(products, navToProductDetail)

            Spacer(modifier = Modifier.height(24.dp))

        }
    }
        //Custom topbar? or just a header?

        // Search Section - Search bar, filter, etc.

        // Recent Searches Section - Recent searches, etc.


}

@Composable
fun RecommendedProducts() {
    Column {
        Title(text = "Recommended")
        // Reccomended products
//        Image(
//            painter = painterResource(id = R.drawable.recommended_products),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(150.dp)
//                .clip(MaterialTheme.shapes.medium)
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//         Image(
//             painter = painterResource(id = R.drawable.recommended_products),
//             contentDescription = null,
//             contentScale = ContentScale.Crop,
//             modifier = Modifier
//                 .fillMaxWidth()
//                 .height(150.dp)
//                 .clip(MaterialTheme.shapes.medium)
//         )
    }
}

@Composable
fun ProductsSearch(navToSearch: () -> Unit) {
    var search by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        // Call Text
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)){
                    withStyle(
                        style = SpanStyle(
                            color = subTitleTextColor,
                            fontSize = 24.sp)
                    ){
                        append("Hi there\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = titleTextColor,
                            fontSize = 24.sp
                        )
                    ){
                        append("Welcome to Mercadeals!")
                    }
                }
            }
        )

        // Search Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 30.dp)
        ){
            TextField(
                modifier = Modifier
                    .weight(0.85f),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = lightbox,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                value = search,
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                onValueChange = { search = it },
                placeholder = {
                    Text(
                        text = "Search for products",
                        color = subTitleTextColor,
                    ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = lightblack
                    )
                },
            )
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .width(60.dp)
                    .padding(start = 16.dp)
                    .clickable { },
                elevation = 5.dp,
                shape = RoundedCornerShape(12.dp),

                ){
                IconButton(
                    onClick = navToSearch,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search",
                        modifier = Modifier.size(20.dp, 20.dp)
                    )
                }
            }
        }

    }
}



@Composable
fun ProductList(products: State<UiState>, navToProductDetail: () -> Unit) {
  Column {
      Title(text = "Products On Sale")

      LazyRow(content = {
          when{
                products.value.isLoading -> {
                    // Loading
                }
                products.value.data != null  -> {
                    items(products.value.data!!.size){ product ->
                        products.value.data!![product].let {
                            ProductCardItem(it, navToProductDetail)
                        }
                    }
                }
                products.value.error -> {
                   // Some Error View
                }
          }
      })
  }
}

@Preview
@Composable
fun PreviewSearchSection(){
    MercaDealsTheme {
        DashboardScreen(
            navToProfile = { /*TODO*/ },
            openDrawer = { /*TODO*/ },
            navToSearch = { /*TODO*/ },
            navToProductDetail = { /*TODO*/ }
        )
    }
}
