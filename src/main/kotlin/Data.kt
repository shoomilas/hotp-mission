data class Data(val bytes: ByteArray) {
    constructor(hexString: String) : this(hexString.toByteArray())
}
//    fun toAsciiArray(): UByteArray {
//        return hexString.toAsciiCodeUByteArray()
//    }

//typealias Data = ByteArray
//fun Data(hexString: String): ByteArray {
//    return hexString.toByteArray()
//}