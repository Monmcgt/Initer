package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register
class JetBrainsToolbox : Entry() {
    override fun execute() {
        runCommand("$home/.local/share/JetBrains/Toolbox/bin/jetbrains-toolbox", arrayOf("--minimize"))
    }
}