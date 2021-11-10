package converter.console.controller

import converter.console.command.CommandConvertFrom
import converter.console.command.CommandConvertTo
import converter.service.NumberConverterService

class AppControllerImpl(
    private val numberConverterService: NumberConverterService
) : AppController {
    override fun convertFrom(command: CommandConvertFrom) {
        val result = numberConverterService.fromDecimal(
            number = command.number.toInt(),
            toBase = command.targetBase,
        )
        println("Conversion result: $result")
    }

    override fun convertTo(command: CommandConvertTo) {
        val result = numberConverterService.toDecimal(
            number = command.number,
            fromBase = command.sourceBase,
        )
        println("Conversion to decimal result: $result")
    }
}
