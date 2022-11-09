package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand

@Register
class CopyQ : Entry() {
    override fun execute() {
        killProcess("copyq", true)
        runCommand("/usr/bin/copyq")
    }
}