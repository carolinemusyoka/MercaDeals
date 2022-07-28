package com.carolmusyoka.mercadeals.room

import android.content.Context
import androidx.room.Room
import com.carolmusyoka.mercadeals.room.db.ProductsDao
import com.carolmusyoka.mercadeals.room.db.ProductsRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideDao(productsRoomDatabase: ProductsRoomDatabase): ProductsDao {
        return productsRoomDatabase.getProductsDao()
    }

    @Provides
    @Singleton
    fun provideProductsRoomDatabase(
        @ApplicationContext appContext: Context
    ): ProductsRoomDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            ProductsRoomDatabase::class.java,
            "products_database"
        ).build()
    }
}