package com.carolmusyoka.mercadeals.room.repo

import com.carolmusyoka.mercadeals.room.db.ProductsRoomDatabase
import com.carolmusyoka.mercadeals.room.entity.ProductsRoom
import javax.inject.Inject

class ProductsRoomRepo @Inject constructor (private val database: ProductsRoomDatabase) {

    suspend fun insertProduct(product: List<ProductsRoom>) =
        database.getProductsDao().insertProducts(product)

    suspend fun updateProduct(productsRoom: ProductsRoom) = database.getProductsDao().updateProducts(productsRoom)

    fun getSavedProducts() = database.getProductsDao().getAllProducts()
}