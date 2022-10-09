package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.I3)
class Polybar : Entry() {
    override fun execute() {
        runCommand("/usr/bin/polybar-msg", "cmd", "quit")?.waitFor()
        runCommand("/usr/bin/polybar", "mainBar")
    }
}