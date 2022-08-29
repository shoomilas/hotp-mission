fun String.toAscii() = this.map { it.code }.joinToString()
fun ByteArray.toHexString() = joinToString("") { it.toString(16).padStart(2, '0') }
fun UByteArray.toHexString() = joinToString("") { it.toString(16).padStart(2, '0') }