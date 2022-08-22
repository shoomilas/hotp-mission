fun main(args: Array<String>) {
    val cryptoLib = CryptoLib()
    val secretKey = Data("HID Global secretKey")
    val counterStartValue: ULong = 0u
    val outputSize: UByte = 6u
    val hotp = Hotp(
        cryptoLib,
        outputSize,
        counterStartValue,
        secretKey
    )
    var HOTPs = mutableListOf<Int>()
    (0..4).forEach { HOTPs.add(Hotp.generateOTP()) }
    val generatedSecretKey = HOTPs.fold("") { acc, i -> (acc + HOTPs[i]).toString() } // TODO: Double-check
    val encryptedMessage = "7f5f44465b5c5c16505b5a4755534c5c5718" // TODO: double-check
    val decryptedMessage = cryptoLib.decrypt(generatedSecretKey, encryptedMessage)
    println(generatedSecretKey)
    println(encryptedMessage)
    println(decryptedMessage)
}

data class Data(val hexString: String)

interface CryptoLibrary {
    fun hmac(key: Data, data: ULong): Data
    fun decrypt(secretKey: String, message: String): String
}
class CryptoLib : CryptoLibrary {
    override fun hmac(key: Data, data: ULong): Data {
        TODO("To implement")
    }

    override fun decrypt(secretKey: String, message: String): String {
        TODO("Not yet implemented")
        val msgData = Data(message)
        // val msg = msgData.bytes // TODO
        val key = secretKey.asciiValues
        val decoded = xor(msg, key)
        val stringMsg = ""
        decoded.foreach { stringMsg.plus( /* ... */  ) }
        return stringMsg
    }

    interface _xorParam {
        val Element: UByte
        val Index: Int
    }

    fun <T,V> xor(_left: T, _right: V): Array<UByte> where T: _xorParam, V: _xorParam  {
        let length = [3,4][1]
    }
}

class Hotp(
    cryptoLib: CryptoLibrary,
    outputSize: UByte,
    counterStartValue: ULong,
    secretKey: Data
) {
    companion object {
        fun generateOTP():Int { return 3 } // TODO: Not implemented yet
    }
}

// Your HOTP object will take four parameters:
//• cryptoLibrary: Implementation of a protocol with a HMAC function using sha1
//• outputSize: Specifying the number of digits in a HOTP value
//• counter: Start value of a counter incrementing with +1 for each output
//• secretKey: The secret key used by the HMAC function