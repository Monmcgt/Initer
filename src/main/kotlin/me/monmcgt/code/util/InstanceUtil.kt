package me.monmcgt.code.util

import me.monmcgt.code.logger.Logger
import java.net.ConnectException
import java.net.ServerSocket
import java.net.Socket
import kotlin.system.exitProcess

object InstanceUtil {
    private const val port: Int = 38765

    fun isAlreadyRunning(): Boolean {
        try {
            val socket = Socket("0.0.0.0", port)
        } catch (e: ConnectException) {
            if (e.message == "Connection refused") {
                return false
            }
        }
        return true
    }

    fun createServerSocket() {
        val tryCount = 10
        var serverSocket: ServerSocket? = null
        Thread {
            while (true) {
                try {
                    serverSocket = ServerSocket(port)
                    break
                } catch (e: ConnectException) {
                    if (e.message == "Address already in use") {
                        Logger.info("Address already in use, trying again in 1 second.")
                        Thread.sleep(1000)
                    }
                }
                Logger.info("Failed to create server socket, exiting...")
                exitProcess(1)
            }
            serverSocket?.accept()
            Logger.info("Received shutdown signal, shutting down...")
            exitProcess(0)
        }.start()
    }

    fun getPort(): Int {
        return port
    }
}