fun String.toAscii() = this.map { it.code }.joinToString()
fun String.toAsciiArray() = this.map { it.code.toUByte() }.toUByteArray()