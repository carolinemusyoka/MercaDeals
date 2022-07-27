package com.carolmusyoka.mercadeals.di

import com.carolmusyoka.mercadeals.data.repository.ProductRepositoryImpl
import com.carolmusyoka.mercadeals.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providesRepository(repositoryImpl: ProductRepositoryImpl): ProductsRepository
}