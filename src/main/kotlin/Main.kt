fun main(args: Array<String>) {
    println("ab".toAscii())
    "ab".toAsciiArray().forEach { println(it) }
    println("S".toAsciiArray().toUByteArray()[0].toInt().toChar())

    decryptMessageWithHotpDataAsKey()
}

fun decryptMessageWithHotpDataAsKey() {
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
    (0..3).forEach { HOTPs.add(Hotp.generateOTP()) }
    val generatedSecretKey = HOTPs.fold("") { acc, i -> (acc + i).toString() }
    val encryptedMessage = "7f5f44465b5c5c16505b5a4755534c5c5718"
    val decryptedMessage = cryptoLib.decrypt(generatedSecretKey, encryptedMessage)
    println(generatedSecretKey)
    println(encryptedMessage)
    println(decryptedMessage)
}