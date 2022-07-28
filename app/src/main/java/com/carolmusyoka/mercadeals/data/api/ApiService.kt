package com.carolmusyoka.mercadeals.data.api

import com.carolmusyoka.mercadeals.domain.model.AllProductsResponse
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
}