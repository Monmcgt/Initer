package me.monmcgt.code.entry

import me.monmcgt.code.entry.DesktopSessions.ANY
import me.monmcgt.code.util.ClassScanner
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


object EntryManager {
    private val tempFile = File("/tmp/.monmcgt/initer/initer.run")
    private var entries: MutableList<Entry> = mutableListOf()
    private var alreadyRun: Boolean = tempFile.exists()
    private var executor: ExecutorService = Executors.newFixedThreadPool(50)

    fun init() {
        scanClass().forEach(EntryManager::registerCommand)
    }

    fun run() {
        val desktopSession = DesktopSessions.getDesktopSession(System.getenv("DESKTOP_SESSION"))
        entries.forEach {
            val info = it.info
            if (!(info.desktopSession == ANY || info.desktopSession == desktopSession)) {
                return
            }
            if (alreadyRun && info.onlyOnce) {
                return
            }
            it.alreadyRun = alreadyRun
            it.desktopSessions = desktopSession
            executor.submit(it::execute)
        }
        if (!alreadyRun) {
            tempFile.parentFile.mkdirs()
            tempFile.createNewFile()
            tempFile.bufferedWriter().use {
                it.write(SimpleDateFormat("yyyy-MM-dd HH:mm:ss\n").format(Date()))
            }
        }
    }

    private fun registerCommand(clazz: Class<*>) {
        val instance = clazz.newInstance() as Entry
        entries.add(instance)
    }

    private fun scanClass(): MutableList<Class<*>> {
        val list = mutableListOf<Class<*>>()
        ClassScanner.getAllClasses("me.monmcgt.code.entry.impl").forEach {
            var valid = false
            val annotations = it.annotations
            if (annotations.isNotEmpty()) {
                annotations.forEach { it2 ->
                    if (checkValidClass(it, it2)) {
                        var superClass = it
                        while (superClass != Entry::class.java) {
                            if (superClass.superclass == null || superClass.superclass == java.lang.Object::class.java) {
                                break
                            }
                            superClass = superClass.superclass
                        }
                        if (superClass == Entry::class.java) {
                            valid = true
                        }
                    }
                }
            }
            if (valid) {
                list.add(it)
            }
        }
        return list
    }

    private fun checkValidClass(clazz: Class<*>, annotation: Annotation): Boolean {
        if (annotation.annotationClass == Register::class) {
            if (clazz.annotations.any { it.annotationClass == Register::class }) {
                return true
            }
        }
        return false
    }
}