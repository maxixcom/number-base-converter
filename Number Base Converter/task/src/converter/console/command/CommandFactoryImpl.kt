package converter.console.command

class CommandFactoryImpl : CommandFactory {
    private val commands: List<(String) -> Command?> = listOf(
        { input -> parseExit(input) },
        { input -> parseBack(input) },
    )

    override fun commandFromString(input: String) = commands.firstNotNullOfOrNull { it(input) } ?: CommandUnknown

    private fun parseExit(input: String): Command? {
        return "^/exit$".toRegex().matchEntire(input)?.let {
            CommandExit
        }
    }

    private fun parseBack(input: String): Command? {
        return "^/back$".toRegex().matchEntire(input)?.let {
            CommandBack
        }
    }
}
