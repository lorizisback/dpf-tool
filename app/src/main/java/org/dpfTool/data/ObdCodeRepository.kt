package org.dpfTool.data

import com.github.eltonvs.obd.command.ObdResponse
import com.github.eltonvs.obd.connection.ObdDeviceConnection
import org.dpfTool.data.model.DpfRegenerationCommand
import java.io.InputStream
import java.io.OutputStream

class ObdCodeRepository (inputStream: InputStream, outputStream: OutputStream){
    private val obdConnection = ObdDeviceConnection(inputStream, outputStream)

    suspend fun getObdCodeValues(): ObdResponse{
        return obdConnection.run(DpfRegenerationCommand())
    }
}