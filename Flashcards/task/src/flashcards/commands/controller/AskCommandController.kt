package flashcards.commands.controller

import flashcards.Deck
import flashcards.printlnAndLog
import flashcards.readlnAndLog

/** Controller for the Ask command */
object AskCommandController : CommandController {

    /**
     * Asks for definitions of random cards and checks if they are correct
     *
     * @param deck the deck with the cards
     */
    override fun performCommand(deck: Deck) {
        printlnAndLog("How many times to ask?")
        val times = readlnAndLog().toInt()
        repeat(times) {
            val card = deck.randomGet()
            printlnAndLog("Print the definition of \"${card.term}\":")
            val answer = readlnAndLog()
            if (answer == card.definition) {
                printlnAndLog("Correct!")
            } else if (deck.containsDefinition(answer)) {
                printlnAndLog("Wrong. The right answer is \"${card.definition}\", " +
                    "but your definition is correct for \"${deck.getTermFromDef(answer)}\".")
                card.increaseMistakes()
            } else {
                printlnAndLog("Wrong. The right answer is \"${card.definition}\".")
                card.increaseMistakes()
            }
        }
    }
}
