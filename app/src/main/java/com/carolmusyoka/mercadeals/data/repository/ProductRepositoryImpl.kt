package com.carolmusyoka.mercadeals.data.repository

import com.carolmusyoka.mercadeals.data.api.ApiService
import com.carolmusyoka.mercadeals.domain.model.*
import com.carolmusyoka.mercadeals.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService): ProductsRepository, BaseRepository() {
    override suspend fun getAllProducts(): NetworkResult<AllProductsResponse> {
       return safeApiCall { apiService.getAllProducts() }
    }

    override suspend fun getProduct(id: Int): NetworkResult<ProductsWithId> {
        return safeApiCall { apiService.getProductById(id) }
    }

    override suspend fun categories(): NetworkResult<ProductCategories> {
        return safeApiCall { apiService.getAllCategories() }
    }

    override suspend fun productUnderCategory(category: String): NetworkResult<ProductsUnderCategoryResponse> {
        return safeApiCall { apiService.getProductsByCategory(category) }
    }


}
