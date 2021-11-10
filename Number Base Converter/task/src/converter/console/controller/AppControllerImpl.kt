package converter.console.controller

import converter.console.command.CommandConvert
import converter.service.NumberConverterService

class AppControllerImpl(
    private val numberConverterService: NumberConverterService
) : AppController {
    override fun convert(command: CommandConvert) {
        val result = numberConverterService.convert(
            number = command.number,
            fromBase = command.sourceBase,
            toBase = command.targetBase,
        )
        println("Conversion result: $result")
    }
}
