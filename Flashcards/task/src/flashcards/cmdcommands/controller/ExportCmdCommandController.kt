package flashcards.cmdcommands.controller

import flashcards.Deck
import java.io.File

/** Controller for the command line export command */
object ExportCmdCommandController : CmdCommandController {

    /**
     * Exports cards to a file at the end of the program
     *
     * @param args contains the name of the file to export to
     * @param deck the deck with the cards to export
     */
    override fun performCmdCommand(args: List<String>, deck: Deck) {
        val fileName = args[0]
        val exportFile = File(fileName)
        deck.exportTo(exportFile)
    }
}
