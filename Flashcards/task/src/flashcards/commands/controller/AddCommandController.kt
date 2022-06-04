package flashcards.commands.controller

import flashcards.*

/** Controller for the Add command */
object AddCommandController : CommandController {

    /**
     * Adds a card to the deck
     *
     * @param deck the deck to add the card to
     */
    override fun performCommand(deck: Deck) {
        printlnAndLog("The card:")
        val term = readlnAndLog()
        if (deck.containsTerm(term)) {
            printlnAndLog("The card \"$term\" already exists.")
            return
        }
        printlnAndLog("The definition of the card:")
        val definition = readlnAndLog()
        if (deck.containsDefinition(definition)) {
            printlnAndLog("The definition \"$definition\" already exists.")
            return
        }
        val card = Card(term, definition)
        deck.add(card)
        printlnAndLog("The pair (\"$term\":\"$definition\") has been added.")
    }
}
