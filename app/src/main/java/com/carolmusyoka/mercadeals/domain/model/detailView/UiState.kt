package com.carolmusyoka.mercadeals.domain.model.detailView

data class UiState(
    val isLoading: Boolean = false,
    val data: ProductDetail? = null,
    val error: Boolean = false
)