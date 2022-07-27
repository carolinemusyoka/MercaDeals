package com.carolmusyoka.mercadeals.domain.usecases

import com.carolmusyoka.mercadeals.domain.model.NetworkResult
import com.carolmusyoka.mercadeals.domain.model.ProductCategories
import com.carolmusyoka.mercadeals.domain.model.ProductsUnderCategoryResponse
import com.carolmusyoka.mercadeals.domain.repository.ProductsRepository
import javax.inject.Inject

class CategoryListUseCase @Inject constructor(private val productsRepository: ProductsRepository) {
    suspend fun invoke(): NetworkResult<ProductCategories> {
        return productsRepository.categories()
    }

}