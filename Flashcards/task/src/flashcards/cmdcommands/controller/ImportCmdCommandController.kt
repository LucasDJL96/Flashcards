package flashcards.cmdcommands.controller

import flashcards.Deck
import java.io.File

/** Controller for the command line import command */
object ImportCmdCommandController : CmdCommandController {

    /**
     * Imports cards from a file at the start of the program
     *
     * @param args contains the name of the file to import from
     * @param deck the deck to import to
     */
    override fun performCmdCommand(args: List<String>, deck: Deck) {
        val fileName = args[0]
        val importFile = File(fileName)
        deck.importFrom(importFile)
    }
}
