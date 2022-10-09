@file:JvmName("Register")

package me.monmcgt.code.entry

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Register(
    val desktopSession: DesktopSessions = DesktopSessions.ANY,
    val onlyOnce: Boolean = false,
)
