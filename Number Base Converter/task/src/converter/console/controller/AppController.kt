package converter.console.controller

import converter.console.command.CommandConvertFrom
import converter.console.command.CommandConvertTo

interface AppController {
    fun convertFrom(command: CommandConvertFrom)
    fun convertTo(command: CommandConvertTo)
}
