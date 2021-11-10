package converter.service

class NumberConverterServiceImpl : NumberConverterService {
    override fun convert(number: String, fromBase: Int, toBase: Int): String {
        return number.toInt(fromBase).toString(toBase)
    }
}
