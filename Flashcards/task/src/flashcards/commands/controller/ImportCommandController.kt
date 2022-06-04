package flashcards.commands.controller

import flashcards.Deck
import flashcards.printlnAndLog
import flashcards.readlnAndLog
import java.io.File
import java.io.FileNotFoundException

/** Controller for the Import command */
object ImportCommandController : CommandController {

    /**
     * Imports cards from a file
     *
     * @param deck the deck to import the cards to
     */
    override fun performCommand(deck: Deck) {
        printlnAndLog("File name:")
        val fileName = readlnAndLog()
        try {
            val cardsImported = deck.importFrom(File(fileName))
            printlnAndLog("$cardsImported cards have been loaded.")
        } catch (e: FileNotFoundException) {
            printlnAndLog("File not found.")
        }
    }
}
