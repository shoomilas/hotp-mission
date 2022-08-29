interface CryptoLibrary {
    fun hmac(key: Data, data: Data): Data
    fun decrypt(secretKey: String, message: String): String
}