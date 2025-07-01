package org.example.Behavioral.CoR

class IsEmptyValidator : AbstractValidator() {
    override fun validate(input: String): ValidationResult {
        if (input.isEmpty()) {
            return ValidationResult.Invalid(message = "Empty input")
        }
        return validateNext(input)
    }
}


class EmailValidator : AbstractValidator() {
    private companion object {
        val EMAIL_REGEX = Regex("[a-zA-Z0-9.+%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    }

    override fun validate(input: String): ValidationResult {
        if (!input.matches(EMAIL_REGEX)) {
            return ValidationResult.Invalid(message = "Invalid email")
        }
        return validateNext(input)
    }
}

class PasswordLengthValidator(private val minLength: Int = 6) : AbstractValidator() {
    override fun validate(input: String): ValidationResult {
        if (input.length < minLength)
            return ValidationResult.Invalid(message = "Min password length is $minLength. Got ${input.length}")
        return validateNext(input)
    }
}