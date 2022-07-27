package com.carolmusyoka.mercadeals.domain.repository


import com.carolmusyoka.mercadeals.domain.model.*


// The repository is responsible for handling the data logic, it is the bridge between the data source and the view model.
interface ProductsRepository {
    suspend fun getAllProducts(): NetworkResult<AllProductsResponse>
    suspend fun getProduct(id: Int): NetworkResult<ProductsWithId>
    suspend fun categories(): NetworkResult<ProductCategories>
    suspend fun productUnderCategory(category: String): NetworkResult<ProductsUnderCategoryResponse>


}