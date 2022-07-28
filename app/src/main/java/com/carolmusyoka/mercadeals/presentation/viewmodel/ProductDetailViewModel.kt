package com.carolmusyoka.mercadeals.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolmusyoka.mercadeals.domain.model.NetworkResult
import com.carolmusyoka.mercadeals.domain.model.detailView.UiState
import com.carolmusyoka.mercadeals.domain.usecases.ProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val productDetailUseCase: ProductDetailUseCase): ViewModel() {
    private val _detailResponse: MutableStateFlow<UiState> = MutableStateFlow(UiState(true, null, false))
    val productDetail get() = _detailResponse

    fun getProductDetail(id:Int) {
        viewModelScope.launch {
            _detailResponse.emit(UiState(true, null, false))
            when (val response = productDetailUseCase.invoke(id)) {
                is NetworkResult.Success -> {
                    _detailResponse.emit(UiState(false, response.value, false))
                }
                is NetworkResult.Failure -> {
                    _detailResponse.emit(UiState(false, null, true))
                }
            }
        }
    }

}
