package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfTemperatureBeforeRegenerationCommand : ObdCommand() {
    // Required
    override val tag = "DPF_TEMPERATURE_BEFORE_REGENERATION"
    override val name = "Dpf temperature before regeneration"
    override val mode = "01"
    override val pid = "0x22A0D6"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}