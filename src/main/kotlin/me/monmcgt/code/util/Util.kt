package me.monmcgt.code.util

import java.text.SimpleDateFormat
import java.util.*

val HOME = env("HOME")

fun runCommand(command: String): Process? {
    return ProcessBuilder(command.split(" ")).start()
}

fun runCommand(command: String, args: Array<String>): Process? {
    return ProcessBuilder(command.split(" ") + args).start()
}

@JvmName("runCommandVarArgs")
fun runCommand(command: String, vararg args: String): Process? {
    return ProcessBuilder(command.split(" ") + args).start()
}

fun runCommandBackground(command: String) {
    ProcessBuilder(arrayListOf("/usr/bin/nohup", command)).start()
}

fun runCommandBackground(command: String, args: Array<String>) {
    ProcessBuilder(arrayListOf("/usr/bin/nohup", command) + args).start()
}

@JvmName("runCommandBackgroundVarArgs")
fun runCommandBackground(command: String, vararg args: String) {
    ProcessBuilder(arrayListOf("/usr/bin/nohup", command) + args).start()
}

fun createProcessBuilder(command: String): ProcessBuilder {
    return ProcessBuilder(command)
}

fun createProcessBuilder(command: String, args: Array<String>): ProcessBuilder {
    return ProcessBuilder(command, *args)
}

@JvmName("createProcessBuilderVarArgs")
fun createProcessBuilder(command: String, vararg args: String): ProcessBuilder {
    return ProcessBuilder(command, *args)
}

fun createProcessBuilder(command: String, args: Array<String>, env: Map<String, String>): ProcessBuilder {
    val processBuilder = ProcessBuilder(command, *args)
    val environment = processBuilder.environment()
    env.forEach { (key, value) ->
        environment[key] = value
    }
    return processBuilder
}

@JvmName("createProcessBuilderVarArgsEnv")
fun createProcessBuilder(command: String, vararg args: String, env: Map<String, String>): ProcessBuilder {
    val processBuilder = ProcessBuilder(command, *args)
    val environment = processBuilder.environment()
    env.forEach { (key, value) ->
        environment[key] = value
    }
    return processBuilder
}

fun killProcess(process: Process) {
    process.destroy()
}

fun killProcess(process: Process, force: Boolean) {
    if (force) {
        process.destroyForcibly()
    } else {
        process.destroy()
    }
}

fun killProcess(name: String, waitFor: Boolean = false) {
    val process = runCommand("/usr/bin/pkill", name)
    if (waitFor) {
        process?.waitFor()
    }
}

fun env(env: String): String {
    return System.getenv(env)
}

fun formattedDate(): String {
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
}