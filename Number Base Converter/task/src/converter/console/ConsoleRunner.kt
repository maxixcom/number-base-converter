package converter.console

import converter.console.command.Command
import converter.console.command.CommandBack
import converter.console.command.CommandConvert
import converter.console.command.CommandExit
import converter.console.controller.AppController

class ConsoleRunner : Runnable {
    private val controller: AppController = Application.appController

    override fun run() {
        main@ while (true) {
            println("Enter two numbers in format: {source base} {target base} (To quit type /exit)")
            val inputFormat = readLine()!!
            if (parseCommand(inputFormat) == CommandExit) {
                break@main
            }
            val (sourceBase, targetBase) = inputFormat.split("\\s+".toRegex(), 2).map(String::toInt)

            do {
                println("Enter number in base $sourceBase to convert to base $targetBase (To go back type /back)")
                val input = readLine()!!
                when (parseCommand(input)) {
                    CommandExit -> break@main
                    CommandBack -> break
                    else -> {
                        controller.convert(
                            CommandConvert(
                                number = input,
                                sourceBase = sourceBase,
                                targetBase = targetBase,
                            )
                        )
                    }
                }
            } while (true)
        }
    }

    private fun parseCommand(input: String): Command {
        return Application.commandFactory.commandFromString(input)
    }
}
