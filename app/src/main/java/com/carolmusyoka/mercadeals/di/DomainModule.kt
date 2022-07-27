package com.carolmusyoka.mercadeals.di

import com.carolmusyoka.mercadeals.domain.repository.ProductsRepository
import com.carolmusyoka.mercadeals.domain.usecases.CategoryListUseCase
import com.carolmusyoka.mercadeals.domain.usecases.ProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideProductListUseCase(productsRepository: ProductsRepository) =
        ProductsUseCase(productsRepository)

    @Provides
    @Singleton
    fun provideCategoryUseCase(productsRepository: ProductsRepository) =
        CategoryListUseCase(productsRepository)
}