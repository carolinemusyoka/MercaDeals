package com.carolmusyoka.mercadeals.domain.model

import com.carolmusyoka.mercadeals.domain.model.uiView.ProductDetail

data class UiState(
    val isLoading: Boolean = false,
    val data: AllProductsResponse? = null,
    val error: Boolean = false
)