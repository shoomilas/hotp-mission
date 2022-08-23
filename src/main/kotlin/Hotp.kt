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