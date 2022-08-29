data class Data(val bytes: ByteArray) {
    constructor(hexString: String) : this(hexString.toByteArray())
}