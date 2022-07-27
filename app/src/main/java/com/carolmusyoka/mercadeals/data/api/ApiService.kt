package com.carolmusyoka.mercadeals.data.api

import com.carolmusyoka.mercadeals.domain.model.AllProductsResponse
import com.carolmusyoka.mercadeals.domain.model.ProductCategories
import com.carolmusyoka.mercadeals.domain.model.ProductsUnderCategoryResponse
import com.carolmusyoka.mercadeals.domain.model.ProductsWithId
import retrofit2.http.GET
import retrofit2.http.Path


// THe ApiService interface is used to define the endpoints for the API
interface ApiService {
    // get all products
    @GET("products")
    suspend fun getAllProducts(): AllProductsResponse

    // products details with id
    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductsWithId

    // product categories
    @GET("categories")
    suspend fun getAllCategories(): ProductCategories

    // products with category id
    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @Path("category") category: String
    ): ProductsUnderCategoryResponse

}