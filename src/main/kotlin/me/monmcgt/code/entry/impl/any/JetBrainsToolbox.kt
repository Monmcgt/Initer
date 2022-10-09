package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.HOME
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand

@Register
class JetBrainsToolbox : Entry() {
    override fun execute() {
        killProcess("jetbrains-toolbox")
        runCommand("$HOME/.local/share/JetBrains/Toolbox/bin/jetbrains-toolbox", "--minimize")
    }
}