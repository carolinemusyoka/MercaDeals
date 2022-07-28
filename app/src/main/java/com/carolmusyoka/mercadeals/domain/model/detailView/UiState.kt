package com.carolmusyoka.mercadeals.domain.model.detailView

import com.carolmusyoka.mercadeals.domain.model.ProductsWithId

data class UiState(
    val isLoading: Boolean = false,
    val data: ProductsWithId? = null,
    val error: Boolean = false
)