interface CryptoLibrary {
    // TODO: get back to data being : ULong
    fun hmac(key: Data, data: Data): Data
    fun decrypt(secretKey: String, message: String): String
}