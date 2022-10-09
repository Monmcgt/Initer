package me.monmcgt.code.logger

object Logger {
    fun info(message: String) {
        ProcessBuilder("/usr/bin/tee", "-a", "/tmp/.monmcgt/initer/latest.log").start().outputStream.bufferedWriter().use {
            it.write(message)
        }
    }
}