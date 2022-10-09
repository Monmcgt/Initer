package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register

@Register(DesktopSessions.I3)
class Wired : Entry() {
    override fun execute() {
        while (true) {
            val process = createProcessBuilder("/usr/bin/wired").start()
            process.waitFor()
            Thread.sleep(3000)
        }
    }
}