interface CryptoLibrary {
    fun hmac(key: Data, data: ULong): Data
    fun decrypt(secretKey: String, message: String): String
}