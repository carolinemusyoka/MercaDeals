package com.carolmusyoka.mercadeals.domain.converters

import com.carolmusyoka.mercadeals.domain.model.Product
import com.carolmusyoka.mercadeals.domain.model.uiView.ProductDetail


fun Product.toProduct() = ProductDetail(
    category = category,
    description = description,
    id = id,
    image = image,
    price = price,
    rating = rating,
    title = title
)