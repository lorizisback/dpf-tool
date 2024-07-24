package org.dpfTool.data.datasource

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import org.dpfTool.data.datasource.model.BluetoothConnection
import org.dpfTool.data.datasource.model.BluetoothConnectionResult
import java.util.UUID
import javax.inject.Inject

class BluetoothDatasource @Inject constructor(
    private val bluetoothAdapter: BluetoothAdapter,
    //private val isBluetoothPermissionGranted: Boolean
) {

    @SuppressLint("MissingPermission")
    suspend fun getBluetoothConnection(macAddress: String): BluetoothConnectionResult {
        //if (!isBluetoothPermissionGranted) return BluetoothConnectionResult.MissingPermission

        try {
            val device = bluetoothAdapter.getRemoteDevice(macAddress)
            val socket = device.createRfcommSocketToServiceRecord(SPP_UUID);
            val connection = BluetoothConnection(
                inputStream = socket.inputStream,
                outputStream = socket.outputStream
            )
            return BluetoothConnectionResult.Success(connection)
        } catch (e: Exception) {
            return BluetoothConnectionResult.ConnectionFailed(e.message ?: e.stackTraceToString())
        }
    }

    private companion object {
        private val SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    }
}