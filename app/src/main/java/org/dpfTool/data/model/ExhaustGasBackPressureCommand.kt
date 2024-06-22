package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class ExhaustGasBackPressureCommand : ObdCommand() {
    // Required
    override val tag = "EXHAUST GAS BACK PRESSURE"
    override val name = "Exhaust gas back pressure"
    override val mode = "01"
    override val pid = "0x22A0D8"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}