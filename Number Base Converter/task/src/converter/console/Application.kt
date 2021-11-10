package converter.console

import converter.console.command.CommandFactoryImpl
import converter.console.controller.AppController
import converter.console.controller.AppControllerImpl
import converter.service.NumberConverterService
import converter.service.NumberConverterServiceImpl

object Application {
    private val numberConverterService: NumberConverterService = NumberConverterServiceImpl()

    val appController: AppController = AppControllerImpl(
        numberConverterService = numberConverterService
    )

    val commandFactory = CommandFactoryImpl()
}
