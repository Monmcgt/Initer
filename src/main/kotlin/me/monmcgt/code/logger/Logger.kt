package me.monmcgt.code.logger

import me.monmcgt.code.util.formattedDate

object Logger {
    fun info(message: String) {
        ProcessBuilder("/usr/bin/tee", "-a", "/tmp/.monmcgt/initer/latest.log").start().outputStream.bufferedWriter().use {
            it.write("[${formattedDate()}] [INFO] $message\n")
        }
    }
}