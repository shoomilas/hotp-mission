import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.experimental.xor
import kotlin.math.min

class CryptoLib : CryptoLibrary {
    override fun decrypt(secretKey: String, message: String): String {
        val msg = message.toByteArray()
        val key = secretKey.toByteArray()
        val decoded = xor(msg, key)
        return String(decoded)
//        var stringMsg = ""
//        decoded.forEach {
//            stringMsg = stringMsg.plus(it.toUByte().toInt().toChar())
//        // Swift code had `Character(UnicodeScalar(ascii))` casting
//        }
//        return stringMsg
    }

    override fun hmac(key: Data, data: Data): Data {
        val hmacAlgorithm = "HmacSHA1"
        val secretKeyAlgorithm = "RAW"
        val hmac = Mac.getInstance(hmacAlgorithm)
        val secretKey = SecretKeySpec(key.bytes, secretKeyAlgorithm)
        hmac.init(secretKey)
        return Data(hmac.doFinal(data.bytes))
    }

    private fun xor(_left: ByteArray, right: ByteArray): ByteArray {
        val length = min(_left.size, right.size)
        val buf = ByteArray(length) { 0 }
        (0 until length).forEach { i ->
            buf[i] = right[i] xor _left[i]
        }
        return buf
    }
}