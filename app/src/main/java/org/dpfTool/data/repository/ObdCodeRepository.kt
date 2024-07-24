package org.dpfTool.data.repository

import com.github.eltonvs.obd.command.ObdResponse
import com.github.eltonvs.obd.connection.ObdDeviceConnection
import org.dpfTool.data.repository.model.DpfRegenerationCommand
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class ObdCodeRepository @Inject constructor() {
    private lateinit var obdConnection: ObdDeviceConnection

    fun setup(input: InputStream, output: OutputStream) {
        obdConnection = ObdDeviceConnection(input, output)
    }

    private fun isInitialised(): Boolean = this::obdConnection.isInitialized

    suspend fun getObdCodeValues(): ObdResponse {
        require(isInitialised())
        return obdConnection.run(DpfRegenerationCommand())
    }
}