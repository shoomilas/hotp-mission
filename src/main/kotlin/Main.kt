fun main(args: Array<String>) {
    decryptMessageWithHotpDataAsKey()
}

fun decryptMessageWithHotpDataAsKey() {
    val cryptoLib = CryptoLib()
    val secretKey = Data("HID Global secretKey")
    val counterStartValue: Long = 0
    val outputSize: Byte = 6
    val hotp = Hotp(
        cryptoLib,
        outputSize,
        counterStartValue,
        secretKey
    )
    var HOTPs = mutableListOf<Int>()
    (0 until 4).forEach { HOTPs.add(hotp.generateOTP()) }

    // val generatedSecretKey = HOTPs.fold("") { acc, i -> (acc + i).toString() }
    val generatedSecretKey = HOTPs.joinToString("")
    val encryptedMessage = "7f5f44465b5c5c16505b5a4755534c5c5718"
    val decryptedMessage = cryptoLib.decrypt(
        generatedSecretKey,
        encryptedMessage
    )

    println("generatedSecretKey: ${generatedSecretKey}")
    println("encryptedMessage: ${encryptedMessage}")
    println("decryptedMessage: ${decryptedMessage}")

    println("===============")
    printCollection(decryptedMessage.toByteArray())
    printCollectionAsHexString(decryptedMessage.toByteArray())
}

fun printCollectionAsHexString(someCollection: ByteArray) {
    println(someCollection.toHexString())
}

fun printCollection(someCollection: ByteArray) {
    someCollection.forEach { it -> print("${it} ") }
    println()
}