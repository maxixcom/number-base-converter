package converter.console.controller

import converter.console.command.CommandConvert

interface AppController {
    fun convert(command: CommandConvert)
}
