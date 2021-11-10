package converter.service

interface NumberConverterService {
    fun convert(number: String, fromBase: Int, toBase: Int): String
    fun fromDecimal(number: Int, toBase: Int) = convert(number.toString(), 10, toBase)
    fun toDecimal(number: Int, fromBase: Int) = convert(number.toString(), fromBase, 10)
}
