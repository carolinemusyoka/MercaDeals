package com.carolmusyoka.mercadeals.domain.model

data class ProductsWithId(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)