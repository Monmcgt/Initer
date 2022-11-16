package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand

@Register(DesktopSessions.I3)
class Autotiling : Entry() {
    override fun execute() {
        killProcess("autotiling", true)
        runCommand("/usr/bin/autotiling")
    }
}