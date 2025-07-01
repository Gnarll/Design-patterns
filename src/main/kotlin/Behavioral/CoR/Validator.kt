package org.example.Behavioral.CoR

// interface for typical handler in the chain of responsibility
interface Validator {
    fun setNext(validator: Validator): Validator
    fun validate(input: String): ValidationResult
}

abstract class AbstractValidator : Validator {
    private var nextValidator: Validator? = null

    override fun setNext(validator: Validator): Validator {
        nextValidator = validator
        return validator
    }

    abstract override fun validate(input: String): ValidationResult

    protected fun validateNext(input: String): ValidationResult =
        nextValidator?.validate(input) ?: ValidationResult.Valid

}

sealed class ValidationResult {
    data object Valid : ValidationResult()
    data class Invalid(val message: String) : ValidationResult()
}