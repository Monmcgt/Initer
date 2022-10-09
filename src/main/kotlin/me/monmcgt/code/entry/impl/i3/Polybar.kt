package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register(DesktopSessions.I3)
class Polybar : Entry() {
    override fun execute() {
        runCommand("$home/.config/polybar/launch.sh")
    }
}