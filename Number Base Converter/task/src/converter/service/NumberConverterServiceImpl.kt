package converter.service

import java.math.BigDecimal
import java.math.BigInteger

class NumberConverterServiceImpl : NumberConverterService {
    override fun convert(number: String, fromBase: Int, toBase: Int): String {
        val parts = number.split(".")
        if (parts.size == 1) {
            return this.convertInteger(number, fromBase, toBase)
        }
        val intPart = this.convertInteger(parts[0], fromBase, toBase)
        val fractionalPart = this.convertFractional(parts[1], fromBase, toBase)
        return "$intPart.$fractionalPart"
    }

    private fun convertInteger(number: String, fromBase: Int, toBase: Int): String {
        return number.toBigInteger(fromBase).toString(toBase)
    }

    private fun convertFractional(number: String, fromBase: Int, toBase: Int): String {
        val decimal = convertFractionalToDecimal(number, fromBase)
        return convertFractionalDecimal(decimal, toBase)
    }

    private fun convertFractionalToDecimal(number: String, fromBase: Int): BigDecimal {
        val input = decodeStringToNumber(number, fromBase)
        return input.mapIndexed { index, i ->
            i.toBigDecimal().setScale(100) / fromBase.toBigDecimal().pow(index + 1)
        }.sumOf { it }
    }

    private fun convertFractionalDecimal(number: BigDecimal, toBase: Int): String {
        if (number.remainder(BigDecimal.ONE) == BigDecimal.ZERO) {
            return "0"
        }
        val result = mutableListOf<BigInteger>()
        var fraction = number.remainder(BigDecimal.ONE)
        for (i in 1..5) {
            val tmp = fraction * toBase.toBigDecimal()
            fraction = tmp.remainder(BigDecimal.ONE)
            if (fraction == BigDecimal.ZERO) {
                break
            }
            result.add(tmp.toBigInteger())
        }
        return result.joinToString("") { it.toString(toBase) }
    }

    private fun decodeStringToNumber(number: String, fromBase: Int): List<Int> {
        return number.map { it.digitToInt(fromBase) }
    }
}

