package me.monmcgt.code.entry

abstract class Entry {
    var info: Register = javaClass.getAnnotation(Register::class.java)

    var alreadyRun: Boolean = false
    var desktopSessions: DesktopSessions? = null

    abstract fun execute()
}