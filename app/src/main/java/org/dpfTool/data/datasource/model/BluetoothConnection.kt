package org.dpfTool.data.datasource.model

import java.io.InputStream
import java.io.OutputStream

data class BluetoothConnection(
    val inputStream: InputStream,
    val outputStream: OutputStream
)

sealed interface BluetoothConnectionResult {
    data class Success(val bluetoothConnection: BluetoothConnection): BluetoothConnectionResult
    data class ConnectionFailed(val reason: String): BluetoothConnectionResult
    data object MissingPermission: BluetoothConnectionResult
}