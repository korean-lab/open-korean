object KoreanUtil {
    @Throws(IllegalArgumentException::class)
    fun buildEunJosa(targetStr: String): String {
        var josa = ""
        val lastChar = targetStr[targetStr.length - 1]
        require(!(lastChar.toInt() < 0xAC00 || lastChar.toInt() > 0xD7A3)) { "It's not Korean Alphabet. Out of range." }
        josa = if ((lastChar.toInt() - 0xAC00) % 28 > 0) "은" else "는"
        return targetStr + josa
    }

    @Throws(IllegalArgumentException::class)
    fun buildGaJosa(targetStr: String): String {
        var josa = ""
        val lastChar = targetStr[targetStr.length - 1]
        require(!(lastChar.toInt() < 0xAC00 || lastChar.toInt() > 0xD7A3)) { "It's not Korean Alphabet. Out of range." }
        josa = if ((lastChar.toInt() - 0xAC00) % 28 > 0) "이가" else "가"
        return targetStr + josa
    }

    @Throws(IllegalArgumentException::class)
    fun buildEulJosa(targetStr: String): String {
        var josa = ""
        val lastChar = targetStr[targetStr.length - 1]
        require(!(lastChar.toInt() < 0xAC00 || lastChar.toInt() > 0xD7A3)) { "It's not Korean Alphabet. Out of range." }
        josa = if ((lastChar.toInt() - 0xAC00) % 28 > 0) "을" else "를"
        return targetStr + josa
    }

    fun buildEunJosaFromEng(targetStr: String): String {
        return when (targetStr[targetStr.length-1].toUpperCase()) {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'O', 'P', 'Q', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' -> {
                "${targetStr}는"
            }
            'L', 'M', 'R' -> {
                "${targetStr}은"
            }
            else -> {
                "$targetStr "
            }
        }
    }
}
