package com.carolmusyoka.mercadeals.domain.model

data class UiState(
    val isLoading: Boolean = false,
    val data: AllProductsResponse? = null,
    val error: Boolean = false
)