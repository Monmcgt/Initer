package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.I3)
class Dunst : Entry() {
    override fun execute() {
        killProcess("dunst", true)
        runCommand("/usr/bin/dunst")
    }
}
