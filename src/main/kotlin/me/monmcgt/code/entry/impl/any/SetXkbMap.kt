package me.monmcgt.code.entry.impl.any

import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.runCommand

@Register(onlyOnce = true)
class SetXkbMap : Entry() {
    override fun execute() {
        runCommand("setxkbmap", "-option", "ctrl:nocaps")
    }
}