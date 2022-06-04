package flashcards.commands

import flashcards.commands.controller.*

/**
 * Enum class representing standard input commands
 *
 * @property command the string to call this command
 * @param controller the controller for this command
 */
enum class Commands(val command: String, val controller: CommandController) {

    /** Command to add a card */
    ADD("add", AddCommandController),

    /** Command to remove a card */
    REMOVE("remove", RemoveCommandController),

    /** Command to import cards from a file */
    IMPORT("import", ImportCommandController),

    /** Command to export cards to a file */
    EXPORT("export", ExportCommandController),

    /** Command to study cards */
    ASK("ask", AskCommandController),

    /** Command to export log to a file */
    LOG("log", LogCommandController),

    /** Command to find the hardest cards */
    HARDEST_CARD("hardest card", HardestCardCommandController),

    /** Command to reset the stats of the cards */
    RESET_STATS("reset stats", ResetStatsCommandController)
    ;

    companion object {

        /** Map to get the command from its corresponding string */
        val fromString = buildMap {
            for (command in Commands.values()) {
                put(command.command, command)
            }
        }
    }

}
