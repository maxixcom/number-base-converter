package converter

import converter.service.NumberConverterService
import converter.service.NumberConverterServiceImpl

typealias Converter = NumberConverterService

fun main() {
    val converter: Converter = NumberConverterServiceImpl()

    println("Enter number in decimal system:")
    val number = readLine()!!
    println("Enter target base:")
    val toBase = readLine()!!.toInt()
    println("Conversion result:")
    println(converter.fromDecimal(number.toInt(), toBase))
}
