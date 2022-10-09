package me.monmcgt.code.entry

abstract class EntryUtility {
    val home = env("HOME")

    fun runCommand(command: String) {
        Runtime.getRuntime().exec(command)
    }

    fun runCommand(command: String, args: Array<String>) {
        Runtime.getRuntime().exec(command, args)
    }

    @JvmName("runCommandVarArgs")
    fun runCommand(command: String, vararg args: String) {
        Runtime.getRuntime().exec(command, args)
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

    fun env(env: String): String {
        return System.getenv(env)
    }
}