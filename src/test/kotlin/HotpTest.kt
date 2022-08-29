import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class HotpTest {
    @ParameterizedTest
    @CsvSource(
        "0, 755224",
        "1, 287082",
        "2, 359152",
        "3, 969429",
        "4, 338314",
        "5, 254676",
        "6, 287922",
        "7, 162583",
        "8, 399871",
        "9, 520489"
    )
    fun generateOTP(counter: String, expected: String) {
        // Arrange
        val secretKey = "12345678901234567890"
        val cut = Hotp(CryptoLib(), 6, 0, Data(secretKey))

        // Act
        var result = ""
        (0 .. counter.toInt()).forEach {
            result = cut.generateOTP().toString()
        }

        // Assert
        Assertions.assertEquals(expected, result)
    }
}