package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.HOME
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.I3)
class Feh : Entry() {
    override fun execute() {
        runCommand("/usr/bin/feh", "--bg-fill", "$HOME/Pictures/Wallpapers/FG-DAqxaAAUPRl7.jpg")
    }
}