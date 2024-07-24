package org.dpfTool.domain

import org.dpfTool.data.repository.ObdCodeRepository
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class SetupObdReaderUseCase @Inject constructor(
    private val obdCodeRepository: ObdCodeRepository
) {
    operator fun invoke(input: InputStream, output: OutputStream) {
        obdCodeRepository.setup(input, output)
    }
}