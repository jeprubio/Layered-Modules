package com.rumosoft.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumosoft.domain.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class TestViewModel @Inject constructor(
    private val sampleUseCase: SampleUseCase,
) : ViewModel() {

    val testState: StateFlow<TestUiState> get() = _testState
    private val _testState = MutableStateFlow<TestUiState>(TestUiState.Loading)

    fun doSomething() {
        viewModelScope.launch {
            sampleUseCase().collect {
                _testState.emit(TestUiState.Success)
            }
        }
    }
}
