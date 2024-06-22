package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfMaximumSootLoadAllowedCommand : ObdCommand() {
    // Required
    override val tag = "DPF_MAXIMUM_SOOT_LOAD_ALLOWED_COMMAND"
    override val name = "Dpf maximum soot load allowed command"
    override val mode = "01"
    override val pid = "0x22A0D3"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}