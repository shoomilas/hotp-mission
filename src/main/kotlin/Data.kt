data class Data(val hexString: String) {
    fun toUByteArray(): UByteArray {
        check(hexString.length % 2 == 0 ) { "Must have an even length" }
        return hexString
            .chunked(2)
            .map { it.toInt(16).toUByte() }
            .toUByteArray()
    }
}