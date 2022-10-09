package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register(DesktopSessions.I3)
class Dunst : Entry() {
    override fun execute() {
        runCommand("/usr/bin/pkill", "dunst")?.waitFor()
        runCommand("/usr/bin/dunst")
    }
}
