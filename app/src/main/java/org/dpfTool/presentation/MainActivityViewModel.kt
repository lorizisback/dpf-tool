package org.dpfTool.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.dpfTool.domain.GetObdCodeUseCase
import org.dpfTool.presentation.model.BluetoothDeviceUiModel
import org.dpfTool.presentation.model.ObdCodeUiModel

class MainActivityViewModel(private val getObdCodeUseCase: GetObdCodeUseCase) : ViewModel() {
    var uiState by mutableStateOf(ObdCodeUiModel())
        private set

    private var fetchObdCodesJob: Job? = null

    fun fetchObdCodes() {
        fetchObdCodesJob?.cancel()
        fetchObdCodesJob = viewModelScope.launch {
            val obdResponse = getObdCodeUseCase.invoke()
            uiState = uiState.copy(
                codeName = obdResponse.command.name,
                codeValue = obdResponse.formattedValue
            )
        }
    }
}

sealed interface ObdCodeRetrievalUiState {
    data class Success(val obdCodeUiModel: ObdCodeUiModel) : ObdCodeRetrievalUiState
    data object InProgress : ObdCodeRetrievalUiState
    data object Failure : ObdCodeRetrievalUiState
}

sealed interface BluetoothConnectionUiState {
    data class Success(val bluetoothDeviceUiModel: BluetoothDeviceUiModel) : BluetoothConnectionUiState
    data object InProgress : BluetoothConnectionUiState
    data object Failure : BluetoothConnectionUiState
}