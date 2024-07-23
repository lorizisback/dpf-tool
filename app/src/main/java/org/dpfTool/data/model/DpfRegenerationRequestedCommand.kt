package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfRegenerationRequestedCommand : ObdCommand() {
    // This command indicates if a regeneration has been requested

    // Required
    override val tag = "DPF_REGENERATION_REQUESTED"
    override val name = "Dpf regeneration requested"
    override val mode = "01"
    override val pid = "0x22A0D5"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}