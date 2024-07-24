package org.dpfTool.data

import com.github.eltonvs.obd.command.ObdResponse
import com.github.eltonvs.obd.connection.ObdDeviceConnection
import org.dpfTool.data.model.DpfCurrentSootLoadCommand
import org.dpfTool.data.model.DpfLastRegenerationDistanceCommand
import org.dpfTool.data.model.DpfLastRegenerationTimeCommand
import org.dpfTool.data.model.DpfMaximumSootLoadAllowedCommand
import org.dpfTool.data.model.DpfRegenerationCurrentStatusCommand
import org.dpfTool.data.model.DpfRegenerationRequestedCommand
import org.dpfTool.data.model.DpfTemperatureAfterRegenerationCommand
import org.dpfTool.data.model.DpfTemperatureBeforeRegenerationCommand
import org.dpfTool.data.model.ExhaustGasBackPressureCommand
import java.io.InputStream
import java.io.OutputStream

class ObdCodeRepository (inputStream: InputStream, outputStream: OutputStream){
    private val obdConnection = ObdDeviceConnection(inputStream, outputStream)

    suspend fun getCurrentSootLoad(): ObdResponse{
        return obdConnection.run(DpfCurrentSootLoadCommand())
    }
    suspend fun getLastRegenerationDistance(): ObdResponse{
        return obdConnection.run(DpfLastRegenerationDistanceCommand())
    }
    suspend fun getLastRegenerationTime(): ObdResponse{
        return obdConnection.run(DpfLastRegenerationTimeCommand())
    }

    suspend fun getMaximumSootLoadAllowed(): ObdResponse{
        return obdConnection.run(DpfMaximumSootLoadAllowedCommand())
    }

    suspend fun getRegenerationCurrentStatus(): ObdResponse{
        return obdConnection.run(DpfRegenerationCurrentStatusCommand())
    }

    suspend fun getRegenerationRequested(): ObdResponse{
        return obdConnection.run(DpfRegenerationRequestedCommand())
    }

    suspend fun getTemperatureAfterRegeneration(): ObdResponse{
        return obdConnection.run(DpfTemperatureAfterRegenerationCommand())
    }

    suspend fun getTemperatureBeforeRegeneration(): ObdResponse{
        return obdConnection.run(DpfTemperatureBeforeRegenerationCommand())
    }

    suspend fun getExhaustGasBackPressure(): ObdResponse{
        return obdConnection.run(ExhaustGasBackPressureCommand())
    }


}