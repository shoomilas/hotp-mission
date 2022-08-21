fun main(args: Array<String>) {
    println("Hello HOTP")
}

class Data {}

interface CryptoLibrary {
    fun hmac(key: Data, data: ULong): Data
    fun decrypt(secretKey: String, message: String): String
}

