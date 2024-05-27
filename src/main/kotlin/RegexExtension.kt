
fun Regex.min(
    size: Int,
) = "$this|^.{${size},}\$".toRegex()

fun Regex.max(
    size: Int,
) = "$this|^.{0,${size}}\$".toRegex()

fun Regex.range(
    min: Int,
    max: Int,
) = "$this|^.{${min},${max}}\$".toRegex()

operator fun Regex.plus(
    other: Regex,
) =
    Regex("(?=.*${this.pattern})(?=.*${other.pattern}).*")

fun Regex.exclude(
    vararg specialCharacters: String,
): Regex {
    val toString = specialCharacters.joinToString { it }
    val charArray = toString.toCharArray()
    charArray.forEach(SpecialCharacterValidator::contains)

    var pattern = this.pattern
    pattern.forEach { char ->
        charArray.forEach { specialChar ->
            if (char == specialChar) {
                pattern = pattern.replace(specialChar.toString(), "")
            }
        }
    }

    return pattern.toRegex()
}