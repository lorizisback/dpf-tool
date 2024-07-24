package org.dpfTool.domain

import com.github.eltonvs.obd.command.ObdResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.dpfTool.data.ObdCodeRepository

class GetLastRegenerationDistanceUseCase (private val obdCodeRepository: ObdCodeRepository,
                                          private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default) {

    suspend operator fun invoke(): ObdResponse{
        val result: ObdResponse
        withContext(defaultDispatcher){
            result = obdCodeRepository.getLastRegenerationDistance()
        }
        return result
    }

}