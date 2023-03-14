package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand
import me.monmcgt.code.util.sleep

@Register
class Clipster : Entry() {
    override fun execute() {
        killProcess("clipster", true)
        sleep(3000)
        runCommand("/usr/bin/clipster", "-d")
    }
}