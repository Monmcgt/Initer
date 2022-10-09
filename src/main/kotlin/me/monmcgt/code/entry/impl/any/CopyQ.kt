package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register
class CopyQ : Entry() {
    override fun execute() {
        runCommand("/usr/bin/copyq")
    }
}