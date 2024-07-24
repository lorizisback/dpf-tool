package org.dpfTool.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.dpfTool.domain.GetLastRegenerationDistanceUseCase
import org.dpfTool.presentation.model.ObdCodeUiState

class ObdCodeViewModel(private val getLastRegenerationDistanceUseCase: GetLastRegenerationDistanceUseCase) : ViewModel() {
    var uiState by mutableStateOf(ObdCodeUiState())
        private set

    private var fetchObdCodesJob: Job? = null

    fun fetchObdCodes() {
        fetchObdCodesJob?.cancel()
        fetchObdCodesJob = viewModelScope.launch {
            val obdResponse = getLastRegenerationDistanceUseCase.invoke()
            uiState = uiState.copy(
                codeName = obdResponse.command.name,
                codeValue = obdResponse.formattedValue
            )
        }
    }
}