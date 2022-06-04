package flashcards

import flashcards.cmdcommands.CmdCommands
import flashcards.commands.Commands

/**
 * Main method. Controls the flow of the program. Performs the command line actions
 * passed to it and asks the user for action though the standard input/output.
 */
fun main(args: Array<String>) {
    val deck = Deck()
    SessionLog.init()
    doCmdCommandIfPresent(CmdCommands.IMPORT, args, deck)
    val commands = Commands.fromString.keys + "exit"
    while (true) {
        printlnAndLog("Input the action (${commands.joinToString(", ", "", "")}):")
        val command = readlnAndLog()
        if (command == "exit") {
            printlnAndLog("Bye bye!")
            doCmdCommandIfPresent(CmdCommands.EXPORT, args, deck)
            return
        }
        if (command !in commands) {
            printlnAndLog("Command not recognized.")
            continue
        }
        val controller = Commands.fromString[command]!!.controller
        controller.performCommand(deck)
        printlnAndLog()
    }
}

/** Prints a blank line to the session log and to the standard output */
fun printlnAndLog() {
    printlnAndLog("")
}

/**
 * Prints text and a new line to the session log and to the standard output
 *
 * @param text the text to print
 */
fun printlnAndLog(text: String) {
    println(text)
    SessionLog.file.appendText(text + "\n")
}

/**
 * Reads a line from the standard input, prints it to the session log
 *
 * @return the line read
 */
fun readlnAndLog(): String {
    val text = readln()
    SessionLog.file.appendText(text + "\n")
    return text
}

/**
 * Checks if a command line command is present and if so, gets the argument and passes
 * it to the corresponding controller
 *
 * @param cmdCommand the command to check
 * @param args the array in which to check if the command is present and get its arguments
 * @param deck the deck for performing actions
 */
fun doCmdCommandIfPresent(cmdCommand: CmdCommands, args: Array<String>, deck: Deck) {
    if (cmdCommand.command in args) {
        val index = args.indexOf(cmdCommand.command)
        val argument = listOf(args[index + 1])
        val controller = cmdCommand.controller
        controller.performCmdCommand(argument, deck)
    }
}
