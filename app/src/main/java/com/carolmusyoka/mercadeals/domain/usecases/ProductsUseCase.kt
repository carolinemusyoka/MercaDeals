package com.carolmusyoka.mercadeals.domain.usecases

import com.carolmusyoka.mercadeals.domain.model.AllProductsResponse
import com.carolmusyoka.mercadeals.domain.model.NetworkResult
import com.carolmusyoka.mercadeals.domain.model.Product
import com.carolmusyoka.mercadeals.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
     suspend fun invoke(): NetworkResult<AllProductsResponse> {
          return productsRepository.getAllProducts()
     }
}
