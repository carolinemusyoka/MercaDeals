package com.carolmusyoka.mercadeals.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolmusyoka.mercadeals.domain.model.NetworkResult
import com.carolmusyoka.mercadeals.domain.model.UiState
import com.carolmusyoka.mercadeals.domain.usecases.CategoryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryListUseCase: CategoryListUseCase): ViewModel() {
    private val _categoryResponse: MutableStateFlow<UiState> = MutableStateFlow(UiState(true, null, false))
    val category get() = _categoryResponse

    fun getCategories() {
        viewModelScope.launch {
            _categoryResponse.emit(UiState(true, null, false))
            when (val response = categoryListUseCase.invoke()) {
                is NetworkResult.Success -> {
                    _categoryResponse.emit(UiState(false, null, false))
                }
                is NetworkResult.Failure -> {
                    _categoryResponse.emit(UiState(false, null, true))
                }
            }
        }
    }

}
