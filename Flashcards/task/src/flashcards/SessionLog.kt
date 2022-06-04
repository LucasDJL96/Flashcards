package flashcards

import java.io.File

/** Object for the log of the current session */
object SessionLog {

    /** The session log file */
    val file = File(".sessionLog")

    /**
     * Initializes the file, deleting all content if it already exists.
     * Deletes the file on normal exit of the virtual machine
     */
    fun init() {
        if (!file.exists()) {
            file.createNewFile()
        } else {
            file.writeText("")
        }
        file.deleteOnExit()
    }
}
