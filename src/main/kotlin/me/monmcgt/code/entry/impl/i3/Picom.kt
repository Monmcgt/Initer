package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.I3)
class Picom : Entry() {
    override fun execute() {
        killProcess("picom", true)
        runCommand("/usr/bin/picom", "-f")
    }
}