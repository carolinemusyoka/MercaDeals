package com.carolmusyoka.mercadeals.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.carolmusyoka.mercadeals.room.entity.ProductsRoom
import com.carolmusyoka.mercadeals.room.repo.ProductsRoomRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelRoom @Inject constructor(private val productsRoomRepo: ProductsRoomRepo) : ViewModel() {
    // Room Functionality
    fun insertProductsData(productsItemsRoom: List<ProductsRoom>) = viewModelScope.launch {
        productsRoomRepo.insertProduct(productsItemsRoom)
    }
    fun getAllProductsFromRoom() = productsRoomRepo.getSavedProducts()

}