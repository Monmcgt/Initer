package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register(DesktopSessions.I3)
class Picom : Entry() {
    override fun execute() {
        runCommand("/usr/bin/pkill", "picom")?.waitFor()
        runCommand("/usr/bin/picom", "-f")
    }
}