package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfCurrentSootLoadCommand : ObdCommand() {
    // Required
    override val tag = "DPF_CURRENT_SOOT_LOAD_COMMAND"
    override val name = "Dpf current soot load"
    override val mode = "01"
    override val pid = "0x22A0D2"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}