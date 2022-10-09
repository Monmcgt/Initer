package me.monmcgt.code.entry

enum class DesktopSessions(val session: String?) {
    ANY("any"),
    KDE("plasma"),
    GNOME("gnome"),
    I3("i3");

    companion object {
        fun getDesktopSession(string: String?): DesktopSessions? {
            for (session in values()) {
                if (session.session == string) {
                    return session
                }
            }
            return null
        }
    }
}