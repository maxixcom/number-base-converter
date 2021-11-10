package converter.console.command

class CommandFactoryImpl : CommandFactory {
    private val commands: List<(String) -> Command?> = listOf(
        { input -> parseExit(input) },
        { input -> parseConvertFrom(input) },
        { input -> parseConvertTo(input) },
    )

    override fun commandFromString(input: String) = commands.firstNotNullOfOrNull { it(input) } ?: CommandUnknown

    private fun parseExit(input: String): Command? {
        return "^/exit$".toRegex().matchEntire(input)?.let {
            CommandExit
        }
    }

    private fun parseConvertFrom(input: String): Command? {
        return "^/from$".toRegex().matchEntire(input)?.let {
            println("Enter a number in decimal system:")
            val number = readLine()!!
            println("Enter the target base:")
            val targetBase = readLine()!!.toInt()
            CommandConvertFrom(number, targetBase)
        }
    }

    private fun parseConvertTo(input: String): Command? {
        return "^/to$".toRegex().matchEntire(input)?.let {
            println("Enter source number:")
            val number = readLine()!!
            println("Enter source base:")
            val targetBase = readLine()!!.toInt()
            CommandConvertTo(number, targetBase)
        }
    }
}
