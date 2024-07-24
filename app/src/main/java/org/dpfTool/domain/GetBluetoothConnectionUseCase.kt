package org.dpfTool.domain

import kotlinx.coroutines.CoroutineScope
import org.dpfTool.data.datasource.BluetoothDatasource
import org.dpfTool.data.datasource.model.BluetoothConnectionResult
import org.dpfTool.di.CoroutineDispatcherProvider
import javax.inject.Inject

class GetBluetoothConnectionUseCase @Inject constructor(
    private val bluetoothDatasource: BluetoothDatasource,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) {
    suspend operator fun invoke() = with(coroutineDispatcherProvider.provideIoDispatcher()) {
        bluetoothDatasource.getBluetoothConnection("13:E0:2F:8D:5E:20")
    }
}