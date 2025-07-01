package org.example.Behavioral.CoR

import org.example.PatternExecutor

fun processInputData(email: String, password: String) {
    val emailValidator = IsEmptyValidator()
        .setNext(EmailValidator())
    val passwordValidator = IsEmptyValidator()
        .setNext(PasswordLengthValidator())

    val emailValidationResult = emailValidator.validate(email)
    val passwordValidationResult = passwordValidator.validate(password)

    when (emailValidationResult) {
        is ValidationResult.Valid ->
            println("Email is ok")

        is ValidationResult.Invalid ->
            println(emailValidationResult.message)
    }

    when (passwordValidationResult) {
        is ValidationResult.Valid ->
            println("Password is ok")

        is ValidationResult.Invalid ->
            println(passwordValidationResult.message)
    }

}

class ChainExecutor : PatternExecutor {
    override fun main() {
        val emailFirstTry = "tequila-sunset@mail.com"
        val passwordFirstTry = "3450D"

        val emailSecondTry = "tequila-sunset@mail.com"
        val passwordSecondTry = "3450DUAUAUAUAUAA"

        processInputData(email = emailFirstTry, password = passwordFirstTry)
        processInputData(email = emailSecondTry, password = passwordSecondTry)
    }
}