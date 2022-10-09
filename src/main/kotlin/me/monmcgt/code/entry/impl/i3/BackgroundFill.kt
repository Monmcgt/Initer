package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.HOME
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.I3)
class BackgroundFill : Entry() {
    override fun execute() {
        runCommand("/usr/bin/feh", "--bg-fill", "$HOME/Pictures/Wallpapers/mountain-landscape-low-poly-minimalist-minimalism-y7313.jpg")
    }
}