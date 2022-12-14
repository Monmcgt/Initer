package me.monmcgt.code.entry.impl.kde

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.KDE)
class LatteDock : Entry() {
    override fun execute() {
        runCommand("/usr/bin/latte-dock")
    }
}