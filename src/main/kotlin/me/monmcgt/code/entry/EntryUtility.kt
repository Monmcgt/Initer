package me.monmcgt.code.entry

abstract class EntryUtility {
    val home = env("HOME")

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

    fun env(env: String): String {
        return System.getenv(env)
    }
}