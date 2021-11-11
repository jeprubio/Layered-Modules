package com.rumosoft.presentation

sealed class TestUiState {
    object Loading : TestUiState()
    object Success : TestUiState()
}
