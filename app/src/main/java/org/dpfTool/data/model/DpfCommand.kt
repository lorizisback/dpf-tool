package org.dpfTool.data.model

import com.github.eltonvs.obd.command.ObdCommand
import com.github.eltonvs.obd.command.ObdRawResponse

class DpfRegenerationCommand : ObdCommand() {
    // Required
    override val tag = "DPF_REGENERATION"
    override val name = "Dpf Regeneration"
    override val mode = "01" // TODO: [DPF-5](https://trello.com/c/NXgtw2qo/5-dpf-5feature-add-dpf-regeneration-mode-and-pid)
    override val pid = "FF"

    // Optional
    override val defaultUnit = ""
    override val handler = { it: ObdRawResponse -> "Calculations to parse value from ${it.processedValue}" }
}
