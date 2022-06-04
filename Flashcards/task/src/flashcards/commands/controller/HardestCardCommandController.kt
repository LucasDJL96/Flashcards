package flashcards.commands.controller

import flashcards.Deck
import flashcards.printlnAndLog

/** Controller for the Hardest Card command */
object HardestCardCommandController : CommandController {

    /**
     * Shows the cards with the most mistakes made
     *
     * @param deck the deck with the cards
     */
    override fun performCommand(deck: Deck) {
        if (deck.isEmpty()) {
            printlnAndLog("There are no cards with errors.")
            return
        }
        val cards = deck.getHardestCards()
        check(cards.isNotEmpty())
        if (cards[0].mistakes == 0) {
            printlnAndLog("There are no cards with errors.")
            return
        }
        if (cards.size == 1) {
            val card = cards[0]
            printlnAndLog("The hardest card is \"${card.term}\". You have ${card.mistakes} errors answering it.")
        } else {
            val mistakes = cards[0].mistakes
            val cardTerms = cards.joinToString("\", \"", "\"", "\"") { it.term }
            printlnAndLog("The hardest cards are $cardTerms. You have $mistakes errors answering them.")
        }
    }
}
