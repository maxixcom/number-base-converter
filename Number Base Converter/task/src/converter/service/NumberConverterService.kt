package converter.service

interface NumberConverterService {
    fun convert(number: String, fromBase: Int, toBase: Int): String
    fun fromDecimal(number: Int, toBase: Int) = convert(number.toString(), 10, toBase)
    fun toDecimal(number: String, fromBase: Int) = convert(number, fromBase, 10)
}
