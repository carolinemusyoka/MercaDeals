package com.carolmusyoka.mercadeals.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolmusyoka.mercadeals.domain.model.NetworkResult
import com.carolmusyoka.mercadeals.domain.model.UiState
import com.carolmusyoka.mercadeals.domain.usecases.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
): ViewModel() {

    private val _productResponse: MutableStateFlow<UiState> = MutableStateFlow(UiState(true, null, false))
    val products get() = _productResponse

    fun getProducts() {
        viewModelScope.launch {
            _productResponse.emit(UiState(true, null, false))
            when (val response = productsUseCase.invoke()) {
                is NetworkResult.Success -> {
                    _productResponse.emit(UiState(false, response.value, false))
                }
                is NetworkResult.Failure -> {
                    _productResponse.emit(UiState(false, null, true))
                }
            }
        }
    }

}