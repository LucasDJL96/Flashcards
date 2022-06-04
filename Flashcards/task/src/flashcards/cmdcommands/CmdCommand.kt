package flashcards.cmdcommands

import flashcards.cmdcommands.controller.CmdCommandController
import flashcards.cmdcommands.controller.ExportCmdCommandController
import flashcards.cmdcommands.controller.ImportCmdCommandController

/**
 * Enum class representing the possible command line commands
 *
 * @property command the string representing this command
 * @property controller the controller for the actions of this command
 */
enum class CmdCommands(val command: String, val controller: CmdCommandController) {

    /** Import command to import cards from a file at the beginning of the program */
    IMPORT("-import", ImportCmdCommandController),

    /** Export command to export cards to a file at the end of a program */
    EXPORT("-export", ExportCmdCommandController),
    ;
}
