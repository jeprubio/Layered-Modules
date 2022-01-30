package com.rumosoft.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumosoft.domain.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val sampleUseCase: SampleUseCase,
) : ViewModel() {

    val testState: StateFlow<TestUiState> = sampleUseCase()
        .map { TestUiState.Success }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = TestUiState.Loading
        )
}
