import kotlin.math.min

class CryptoLib : CryptoLibrary {
    override fun hmac(key: Data, data: ULong): Data {
        TODO("HMAC function To implement")
    }

    override fun decrypt(secretKey: String, message: String): String {
        val msg = Data(message).toAsciiArray()
        val key = secretKey.toAsciiArray()
        val decoded = xor(msg, key)
        val stringMsg = ""
        decoded.forEach {
            stringMsg.plus(it.toInt().toChar()) // Swift code had `Character(UnicodeScalar(ascii))` casting
        }
        return stringMsg
    }

    private fun <T, V> xor(_left: T, _right: V): UByteArray where T: Iterable<UByte>, V: Iterable<UByte> {
        val length = min(_left.count(), _right.count())
        val buf = MutableList<UByte>(length) { 0u }
        (0 until length).forEach { i ->
            buf[i] = _left.elementAt(i) xor _right.elementAt(i)
        }
        return buf.toUByteArray()
    }
}