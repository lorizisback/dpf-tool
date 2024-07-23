package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfRegenerationCurrentStatusCommand : ObdCommand() {
    // Required
    override val tag = "DPF_REGENERATION_CURRENT_STATUS"
    override val name = "Dpf regeneration current status"
    override val mode = "01"
    override val pid = "0x22A0D4"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}