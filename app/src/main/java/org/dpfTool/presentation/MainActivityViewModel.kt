package org.dpfTool.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.dpfTool.data.datasource.model.BluetoothConnection
import org.dpfTool.data.datasource.model.BluetoothConnectionResult
import org.dpfTool.domain.GetBluetoothConnectionUseCase
import org.dpfTool.domain.GetObdCodeUseCase
import org.dpfTool.domain.SetupObdReaderUseCase
import org.dpfTool.presentation.model.BluetoothDeviceUiModel
import org.dpfTool.presentation.model.ObdCodeUiModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getObdCodeUseCase: GetObdCodeUseCase,
    private val setupObdReaderUseCase: SetupObdReaderUseCase,
    private val getBluetoothConnectionUseCase: GetBluetoothConnectionUseCase
) : ViewModel() {
    var obdUiState: MutableState<ObdCodeRetrievalUiState> =
        mutableStateOf(ObdCodeRetrievalUiState.Initialised)
        private set

    var bluetoothUiState: MutableState<BluetoothConnectionUiState> = mutableStateOf(
        BluetoothConnectionUiState.Initialised
    )
        private set

    private var fetchObdCodesJob: Job? = null

    fun fetchObdCodes() {
        fetchObdCodesJob?.cancel()
        fetchObdCodesJob = viewModelScope.launch {
            val obdResponse = getObdCodeUseCase.invoke()
            val state = ObdCodeRetrievalUiState.Success(
                ObdCodeUiModel(
                    codeName = obdResponse.command.name,
                    codeValue = obdResponse.formattedValue
                )
            )
            obdUiState.value = state
        }
    }

    fun connectToCar() {
        viewModelScope.launch {
            when (val bluetoothConnectionResult = getBluetoothConnectionUseCase()) {
                is BluetoothConnectionResult.Success -> setupObdReader(
                    bluetoothConnectionResult.bluetoothConnection
                )
                else -> bluetoothUiState.value = BluetoothConnectionUiState.Failure
            }
        }
    }

    private fun setupObdReader(bluetoothConnection: BluetoothConnection) {
        with(bluetoothConnection) {
            setupObdReaderUseCase(inputStream, outputStream)
        }
        fetchObdCodes()
    }
}

sealed interface ObdCodeRetrievalUiState {
    data class Success(val obdCodeUiModel: ObdCodeUiModel) : ObdCodeRetrievalUiState
    data object InProgress : ObdCodeRetrievalUiState
    data object Failure : ObdCodeRetrievalUiState
    data object Initialised : ObdCodeRetrievalUiState
}

sealed interface BluetoothConnectionUiState {
    data class Success(val bluetoothDeviceUiModel: BluetoothDeviceUiModel) :
        BluetoothConnectionUiState

    data object InProgress : BluetoothConnectionUiState
    data object Failure : BluetoothConnectionUiState
    data object Initialised : BluetoothConnectionUiState

}