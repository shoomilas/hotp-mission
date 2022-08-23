class CryptoLib : CryptoLibrary {
    override fun hmac(key: Data, data: ULong): Data {
        TODO("To implement")
    }

    override fun decrypt(secretKey: String, message: String): String {
        TODO("Not yet implemented")
        val msg = Data(message).toUByteArray()
        val key = secretKey.toAsciiArray()
        val decoded = xor(msg, key)
        val stringMsg = ""
//        decoded.foreach { stringMsg.plus( /* ... */  ) } // TODO: <-
        return stringMsg
    }

    fun <T,V> xor(_left: T, _right: V): UByteArray where T: Iterable<UByte>, V: Iterable<UByte>  {
        return UByteArray(1) { 0.toUByte() } // TODO: <-
    }
}