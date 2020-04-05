package com.losingtimeapps.testionix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.losingtimeapps.testionix.domain.usecase.GetDataUseCase

class MainViewModelFactory(
    private val getDataUseCase: GetDataUseCase
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            getDataUseCase
        ) as T
    }
}