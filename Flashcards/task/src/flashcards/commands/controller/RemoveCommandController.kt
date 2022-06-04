package flashcards.commands.controller

import flashcards.Deck
import flashcards.printlnAndLog
import flashcards.readlnAndLog

/** Controller for the Remove command */
object RemoveCommandController : CommandController {

    /**
     * Removes a card from the deck
     *
     * @param deck the deck from which to remove the card
     */
    override fun performCommand(deck: Deck) {
        printlnAndLog("Which card?")
        val term = readlnAndLog()
        if (deck.containsTerm(term)) {
            deck.remove(term)
            printlnAndLog("The card has been removed.")
        } else {
            printlnAndLog("Can't remove \"$term\": there is no such card.")
        }
    }
}
