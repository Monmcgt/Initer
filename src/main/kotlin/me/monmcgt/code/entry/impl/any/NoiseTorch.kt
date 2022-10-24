package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.runCommand
import me.monmcgt.code.util.sleep

@Register
class NoiseTorch : Entry() {
    override fun execute() {
        sleep(5000)
        runCommand("/usr/bin/noisetorch", "-i")
    }
}