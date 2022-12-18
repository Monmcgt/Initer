package me.monmcgt.code.entry.impl.i3

import me.monmcgt.code.entry.DesktopSessions
import me.monmcgt.code.entry.Entry
import me.monmcgt.code.entry.Register
import me.monmcgt.code.util.killProcess
import me.monmcgt.code.util.runCommand
import java.io.File

@Register(DesktopSessions.I3)
class Picom : Entry() {
    override fun execute() {
        killProcess("picom", true)
        runCommand("/usr/bin/picom", readRunArgs())
    }

    private fun readRunArgs(): Array<String> {
        val configDir = System.getenv("XDG_CONFIG_HOME") ?: "${System.getProperty("user.home")}/.config"
        val argsFile = File("$configDir/picom/args.txt")
        return if (argsFile.exists()) {
            argsFile.readLines().filterNot { it.startsWith("#") }.map { line -> line.split("\\s+".toRegex()) }.flatten().filter { it.isNotEmpty() }.toTypedArray()
        } else {
            emptyArray()
        }
    }
}