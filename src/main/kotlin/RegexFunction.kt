fun Regex.min(
    size: Int,
) = "$this|^.{${size},}\$".toRegex()

fun Regex.max(
    size: Int,
) = "$this|^.{0,${size}}\$".toRegex()

fun Regex.length(
    min: Int,
    max: Int,
) = "$this|^.{${min},${max}}\$".toRegex()

operator fun Regex.plus(
    other: Regex,
): Regex {
    val first = this.pattern
        .removePrefix("^")
        .removePrefix("(?=.*")
        .removePrefix(".")
        .removeSuffix("$")
        .removeSuffix("*")
        .removeSuffix(".")
        .removeSuffix(")")

    val second = other.pattern
        .removePrefix("^")
        .removePrefix("*$")
        .removePrefix(".")
        .removeSuffix("*$")
        .removeSuffix(".")
        .removeSuffix(")")

    val value = "$first)(?=.*$second)"
    return Regex("^(?=.*${value}.*$")
}

fun Regex.exclude(
    vararg specialCharacters: String,
): Regex {
    val stringValue = specialCharacters.joinToString("")
    val charArray = stringValue.toCharArray().distinct()
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

fun Regex.include(
    vararg specialCharacters: String,
): Regex {
    val stringValue = specialCharacters.joinToString("")
    val charArray = stringValue.toCharArray().distinct()
    charArray.forEach(SpecialCharacterValidator::contains)

    val pattern = "${charArray.joinToString()}\$"
    return pattern.toRegex()
}