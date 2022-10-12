package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand

@Register
class KdeConnectIndicator : Entry() {
    override fun execute() {
        killProcess("kdeconnect-indicator", true)
        runCommand("/usr/bin/kdeconnect-indicator")
    }
}