package flashcards.commands.controller

import flashcards.Deck
import flashcards.printlnAndLog
import flashcards.readlnAndLog
import java.io.File

/** Controller for the Export command */
object ExportCommandController : CommandController {

    /**
     * Exports the cards in the deck to a file
     *
     * @param deck the deck with the cards to export
     */
    override fun performCommand(deck: Deck) {
        printlnAndLog("File name:")
        val fileName = readlnAndLog()
        val cardsExported = deck.exportTo(File(fileName))
        printlnAndLog("$cardsExported cards have been saved.")
    }
}
