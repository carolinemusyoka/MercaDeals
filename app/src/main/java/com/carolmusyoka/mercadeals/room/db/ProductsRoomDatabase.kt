package com.carolmusyoka.mercadeals.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.carolmusyoka.mercadeals.room.entity.Converters
import com.carolmusyoka.mercadeals.room.entity.ProductsRoom


@Database(
    entities = [ProductsRoom::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ProductsRoomDatabase: RoomDatabase(){
    abstract fun getProductsDao(): ProductsDao

    companion object{
        @Volatile
        private var instance: ProductsRoomDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ProductsRoomDatabase::class.java,
            "products_database"
        ).build()
    }
}
