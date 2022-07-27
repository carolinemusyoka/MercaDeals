package com.carolmusyoka.mercadeals.presentation

import com.carolmusyoka.mercadeals.domain.model.Product

data class ProductsState(
    val products: List<Product> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)