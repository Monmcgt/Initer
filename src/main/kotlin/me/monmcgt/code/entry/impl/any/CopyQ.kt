package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.runCommand
import me.monmcgt.code.util.sleep

@Register
class CopyQ : Entry() {
    override fun execute() {
        runCommand("/usr/bin/copyq", "exit")?.waitFor()
        sleep(2000)
        runCommand("/usr/bin/copyq")
    }
}