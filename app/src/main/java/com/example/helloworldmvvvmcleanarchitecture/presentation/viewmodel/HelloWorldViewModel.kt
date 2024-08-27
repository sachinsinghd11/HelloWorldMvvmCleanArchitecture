package com.example.helloworldmvvvmcleanarchitecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helloworldmvvvmcleanarchitecture.domain.model.WelcomeText
import com.example.helloworldmvvvmcleanarchitecture.domain.usecase.HelloWorldUseCase
import com.example.helloworldmvvvmcleanarchitecture.presentation.base.UiState
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.DispatcherProvider
import com.example.helloworldmvvvmcleanarchitecture.presentation.utils.NetworkHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HelloWorldViewModel(
    private val useCase: HelloWorldUseCase,
    private val networkHelper: NetworkHelper,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<WelcomeText>>(UiState.Loading)

    val uiState: MutableStateFlow<UiState<WelcomeText>> = _uiState

    init {
        fetchWelcomeText()
    }

    private fun fetchWelcomeText() {
        viewModelScope.launch(dispatcherProvider.main) {
            if (networkHelper.isNetworkAvailable()) {
                useCase.invoke()
                    .flowOn(dispatcherProvider.io)
                    .catch { e ->
                        _uiState.value = UiState.Error(e.toString())
                    }
                    .collect {
                        _uiState.value = UiState.Success(it)
                    }
            } else {
                _uiState.value = UiState.Error("Network Issue")
            }

        }
    }

}