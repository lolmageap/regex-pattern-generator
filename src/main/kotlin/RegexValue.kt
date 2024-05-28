
val Regex.Companion.email
    get() = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$".toRegex()

val Regex.Companion.phone
    get() = "^\\d{3}-\\d{3,4}-\\d{4}\$".toRegex()

val Regex.Companion.date
    get() = "^\\d{4}-\\d{2}-\\d{2}\$".toRegex()

val Regex.Companion.time
    get() = "^\\d{2}:\\d{2}\$".toRegex()

val Regex.Companion.dateTime
    get() = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}\$".toRegex()

val Regex.Companion.url
    get() = "^http[s]?://[^\\s]+\$".toRegex()

val Regex.Companion.ip
    get() = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\$".toRegex()

val Regex.Companion.alphabet
    get() = "^[a-zA-Z]*\$".toRegex()

val Regex.Companion.number
    get() = "^[0-9]*\$".toRegex()

val Regex.Companion.korean
    get() = "^[가-힣]*\$".toRegex()

val Regex.Companion.specialCharacter
    get() = "^[!@#\$%^&*()_+\\-=\\[\\]{};':\\\"\\\\|,.<>\\/?]*\$".toRegex()