package flashcards.commands.controller

import flashcards.Deck
import flashcards.printlnAndLog

/** Controller for the Reset Stats command */
object ResetStatsCommandController : CommandController {

    /**
     * Resets the stats of the cards in the deck
     *
     * @param deck the deck with the cards
     */
    override fun performCommand(deck: Deck) {
        deck.resetStats()
        printlnAndLog("Card statistics have been reset.")
    }
}
