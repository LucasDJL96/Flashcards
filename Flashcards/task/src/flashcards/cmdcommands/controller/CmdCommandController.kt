package flashcards.cmdcommands.controller

import flashcards.Deck

/** Interface for controllers for command line commands */
interface CmdCommandController {

    /**
     * Performs the action of the command
     *
     * @param args the arguments the command is called with
     * @param deck the deck object of the command
     */
    fun performCmdCommand(args: List<String>, deck: Deck)

}
