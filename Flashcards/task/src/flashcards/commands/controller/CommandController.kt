package flashcards.commands.controller

import flashcards.Deck

/** Interface for standard input command controllers */
interface CommandController {

    /**
     * Performs the action of the command
     *
     * @param deck the deck used for the command
     */
    fun performCommand(deck: Deck)

}
