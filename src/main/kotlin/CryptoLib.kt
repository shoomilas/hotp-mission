class CryptoLib : CryptoLibrary {
    override fun hmac(key: Data, data: ULong): Data {
        TODO("HMAC function To implement")
    }

    override fun decrypt(secretKey: String, message: String): String {
        val msg = Data(message).toUByteArray()
        val key = secretKey.toAsciiArray()
        val decoded = xor(msg, key)
        val stringMsg = ""
        decoded.forEach {
            stringMsg.plus(it.toInt().toChar()) // Swift code had `Character(UnicodeScalar(ascii))` casting
        }
        return stringMsg
    }

    fun <T,V> xor(_left: T, _right: V): UByteArray where T: Iterable<UByte>, V: Iterable<UByte>  {
        return UByteArray(1) { 0.toUByte() } // TODO: xor function, should return ascii codes
    }
}