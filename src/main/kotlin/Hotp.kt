import java.nio.ByteBuffer
import kotlin.experimental.and

class Hotp(
    val cryptoLib: CryptoLibrary,
    val outputSize: Byte = 6,
    counterStartValue: Long = 0,
    val secretKey: Data
) {
    var counter = counterStartValue;
    fun generateOTP(): Int {
        val counterBytes = ByteBuffer
            .allocate(8)
            .putLong(counter)
            .array()
        val hash = cryptoLib.hmac(secretKey, Data(counterBytes))
        val truncated = dynamicTruncation(hash.bytes)
        counter++
        return truncate(truncated, outputSize)
    }

    private fun dynamicTruncation(hmacResult : ByteArray): Int {
        val offset = (hmacResult.last() and 0xf).toInt()
        // 31-bit, unsigned, big-endian integer; the first byte is masked with a 0x7f.
        val byte1 = (hmacResult[offset] and 0x7f).toInt() shl 24
        val byte2 = hmacResult[offset + 1].toUByte().toInt() shl 16
        val byte3 = hmacResult[offset + 2].toUByte().toInt() shl 8
        val byte4 = hmacResult[offset + 3].toUByte().toInt()
        val binCode = byte1 or byte2 or byte3 or byte4
        return binCode
    }

    private fun truncate(num: Int, outputSize: Byte): Int {
        check(outputSize > 0)
        val modulo = Math.pow(10.0, outputSize.toDouble()).toInt()
        return num % modulo
    }
}