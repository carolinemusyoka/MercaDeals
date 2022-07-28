package com.carolmusyoka.mercadeals.domain.usecases

import com.carolmusyoka.mercadeals.domain.model.NetworkResult
import com.carolmusyoka.mercadeals.domain.model.ProductsWithId
import com.carolmusyoka.mercadeals.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductDetailUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
    suspend fun invoke(id: Int): NetworkResult<ProductsWithId> {
        return productsRepository.getProduct(id)
    }

}