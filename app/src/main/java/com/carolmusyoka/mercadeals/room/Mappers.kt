package com.carolmusyoka.mercadeals.room

import com.carolmusyoka.mercadeals.domain.model.AllProductsResponse
import com.carolmusyoka.mercadeals.domain.model.Product
import com.carolmusyoka.mercadeals.room.entity.ProductsRoom

fun Product.toProductRoom(): ProductsRoom{
    return ProductsRoom(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}