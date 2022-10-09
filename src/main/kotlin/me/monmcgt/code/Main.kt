@file:JvmName("Main")

package me.monmcgt.code

import me.monmcgt.code.entry.EntryManager
import java.util.concurrent.Executors

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(System::gc, 0, 1, java.util.concurrent.TimeUnit.MINUTES)
        EntryManager.init()
        println("[INFO] Done initialising")
        EntryManager.run()
    }
}