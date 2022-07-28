package com.carolmusyoka.mercadeals.data.api


// The ApiHelper class is a singleton class that is used to make network calls to the API.
class ApiHelper (private val apiService: ApiService) {

    suspend fun getAllProducts() = apiService.getAllProducts()

    suspend fun getProductWithId(productId: Int) = apiService.getProductById(productId)

}
