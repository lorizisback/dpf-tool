package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfLastRegenerationDistanceCommand : ObdCommand() {
    // Required
    override val tag = "DPF_LAST_REGENERATION_DISTANCE"
    override val name = "Dpf last regeneration distance"
    override val mode = "01"
    override val pid = "0x22A0D0"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}
