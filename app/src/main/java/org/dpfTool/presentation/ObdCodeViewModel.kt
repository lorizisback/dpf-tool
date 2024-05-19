package org.dpfTool.presentation

import android.provider.Settings.Global.getString
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.dpfTool.R
import org.dpfTool.domain.GetObdCodeUseCase
import org.dpfTool.presentation.model.ObdCodeUiState
import java.io.IOException

class ObdCodeViewModel(private val getObdCodeUseCase: GetObdCodeUseCase) : ViewModel() {
    var uiState by mutableStateOf(ObdCodeUiState())
        private set

    private var fetchObdCodesJob: Job? = null

    fun fetchObdCodes() {
        fetchObdCodesJob?.cancel()
        fetchObdCodesJob = viewModelScope.launch {
            uiState = try {
                val obdResponse = getObdCodeUseCase.invoke()
                uiState.copy(
                    codeName = obdResponse.command.name,
                    codeValue = obdResponse.formattedValue
                )
            } catch (ioe : IOException){
                uiState.copy(codeName = "error retrieving dpf values")
            }
        }
    }
}