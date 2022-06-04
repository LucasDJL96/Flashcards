package flashcards.commands.controller

import flashcards.Deck
import flashcards.SessionLog
import flashcards.printlnAndLog
import flashcards.readlnAndLog
import java.io.File

/** Controller for the Log command */
object LogCommandController : CommandController {

    /** File with the session log */
    private val sessionLog = SessionLog.file

    /**
     * Saves the current session log to a file
     *
     * @param deck ignored
     */
    override fun performCommand(deck: Deck) {
        printlnAndLog("File name:")
        val fileName = readlnAndLog()
        val logFile = File(fileName)
        logFile.createNewFile()
        logFile.writeText(sessionLog.readText())
        printlnAndLog("The log has been saved.")
    }
}
