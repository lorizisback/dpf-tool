package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfLastRegenerationTimeCommand : ObdCommand() {
    // Required
    override val tag = "DPF_LAST_REGENERATION_TIME"
    override val name = "Dpf last regeneration time"
    override val mode = "01"
    override val pid = "0x22A0D1"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}