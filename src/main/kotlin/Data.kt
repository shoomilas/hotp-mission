data class Data(val hexString: String) {
    fun toAsciiArray(): UByteArray {
        return hexString.toAsciiArray()
    }
}