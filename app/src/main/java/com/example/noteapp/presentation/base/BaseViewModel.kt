package com.example.noteapp.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Either
import com.example.noteapp.presentation.ui.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    @Suppress("FunctionName")
    protected fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    protected fun <T, S> Flow<Either<String, T>>.collectRequest(
        state: MutableStateFlow<UIState<S>>,
        mappedData: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mappedData(it.value))
                }
            }
        }
    }
}