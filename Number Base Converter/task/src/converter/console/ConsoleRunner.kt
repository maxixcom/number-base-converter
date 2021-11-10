package converter.console

import converter.console.command.Command
import converter.console.command.CommandConvertFrom
import converter.console.command.CommandConvertTo
import converter.console.command.CommandExit
import converter.console.command.CommandUnknown
import converter.console.controller.AppController

class ConsoleRunner : Runnable {
    private val controller: AppController = Application.appController

    override fun run() {
        main@ while (true) {
            do {
                printGreeting()
                val command = enterCommand()
                when (command) {
                    CommandExit -> break@main
                    is CommandConvertFrom -> controller.convertFrom(command)
                    is CommandConvertTo -> controller.convertTo(command)
                    is CommandUnknown -> println("Wrong command...")
                }
            } while (command == CommandUnknown)
        }
    }

    private fun enterCommand(): Command {
        return Application.commandFactory.commandFromString(readLine()!!)
    }
}
