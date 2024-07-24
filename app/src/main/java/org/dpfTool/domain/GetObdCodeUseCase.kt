package org.dpfTool.domain

import com.github.eltonvs.obd.command.ObdResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.dpfTool.data.repository.ObdCodeRepository
import org.dpfTool.di.CoroutineDispatcherProvider
import javax.inject.Inject

class GetObdCodeUseCase @Inject constructor(
    private val obdCodeRepository: ObdCodeRepository,
    private val dispatcherProvider: CoroutineDispatcherProvider
) {

    suspend operator fun invoke(): ObdResponse {
        val result: ObdResponse
        withContext(dispatcherProvider.provideMainDispatcher()) {
            result = obdCodeRepository.getObdCodeValues()
        }
        return result
    }

}