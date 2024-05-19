package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfRegenerationCommand : ObdCommand() {
    // Required
    override val tag = "DPF_REGENERATION"
    override val name = "Dpf Regeneration"
    override val mode = "01"
    override val pid = "FF"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}
