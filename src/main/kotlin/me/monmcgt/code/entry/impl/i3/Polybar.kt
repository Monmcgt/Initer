package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register(DesktopSessions.I3)
class Polybar : Entry() {
    override fun execute() {
        // Not working, I don't know why...
        // runCommandBackground("$home/.config/polybar/launch.sh")

        runCommand("/usr/bin/polybar-msg", "cmd", "quit")?.waitFor()
        val process = runCommand("/usr/bin/polybar", "mainBar") ?: return
        val tee = runCommand("/usr/bin/tee", "-a", "$home/tmp/polybar/polybar.log") ?: return
        process.inputStream.copyTo(tee.outputStream)
    }
}