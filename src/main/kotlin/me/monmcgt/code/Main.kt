@file:JvmName("Main")

package me.monmcgt.code

import me.monmcgt.code.entry.EntryManager
import me.monmcgt.code.logger.Logger
import me.monmcgt.code.util.InstanceUtil
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(System::gc, 0, 1, TimeUnit.MINUTES)
        if (InstanceUtil.isAlreadyRunning()) {
            Logger.info("Found another instance of Initer running, sending shutdown signal.")
            Thread.sleep(1000)
        }
        InstanceUtil.createServerSocket()
        EntryManager.init()
        Logger.info("Done initialising.")
        EntryManager.run()
    }
}