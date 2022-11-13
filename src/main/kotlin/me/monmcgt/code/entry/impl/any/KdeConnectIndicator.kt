package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand
import me.monmcgt.code.util.sleep

@Register
class KdeConnectIndicator : Entry() {
    override fun execute() {
        killProcess("kdeconnect-indicator", true)
        sleep(5000)
        runCommand("/usr/bin/kdeconnect-indicator")
    }
}