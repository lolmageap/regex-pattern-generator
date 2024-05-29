
object SpecialCharacterValidator {
    fun contains(
        value: Char,
    ) {
        val matches = specialCharacters.any { it.contains(value) }
        if (!matches) error("특수문자를 포함해야 합니다.")
    }

    private val specialCharacters = arrayListOf("!", "@", "#", "\$", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "[", "/")
}