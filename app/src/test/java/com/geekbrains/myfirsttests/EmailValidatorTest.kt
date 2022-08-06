package com.geekbrains.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

private val correctList = listOf(
    "name@email.com",
    "name@email.co.uk",
)

private val incorrectList = listOf(
    "name@email",
    "name@email.",
    "name@email..com",
    "@email.com",
    "",
    null,
    "name.email.com",
)

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail(correctList[0]))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail(correctList[1]))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[0]))
    }

    @Test
    fun emailValidator_InvalidEmailSingleDotNoDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[1]))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[2]))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[3]))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[4]))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[5]))
    }

    @Test
    fun emailValidator_NoAtSymbol_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(incorrectList[6]))
    }
}
