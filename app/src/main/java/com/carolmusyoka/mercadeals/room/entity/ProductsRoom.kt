package com.carolmusyoka.mercadeals.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.carolmusyoka.mercadeals.domain.model.Rating

@Entity
data class ProductsRoom(
    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "description")
    val description: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "price")
    val price: Double,
    // provide a converter for Rating
    @ColumnInfo(name = "rating")
    val rating: Rating,
    @ColumnInfo(name = "title")
    val title: String
){

}
