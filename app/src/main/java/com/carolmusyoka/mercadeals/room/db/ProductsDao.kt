package com.carolmusyoka.mercadeals.room.db

import androidx.room.*
import com.carolmusyoka.mercadeals.room.entity.ProductsRoom

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProducts(product: List<ProductsRoom>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProducts(product: ProductsRoom)

    @Query("SELECT * FROM ProductsRoom")
    fun getAllProducts(): List<ProductsRoom>
}