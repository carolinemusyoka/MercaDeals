package com.carolmusyoka.mercadeals.domain.model.detailView

import com.carolmusyoka.mercadeals.domain.model.Rating

data class ProductDetail(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)