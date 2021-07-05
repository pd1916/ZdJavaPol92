package pl.sdacademy.unit.test.basic.exercises.tdd.task5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"sda@sda.pl", "sda@sda.com.pl", "sda.sda@sda.pl", "sda?sda@sda.pl", "sda^sda@sda.pl", "1sda^sda@sda.pl"})
    void shouldReturnTrueForValidEmailAddress(String input) {
        //when
        boolean result = EmailValidation.validate(input);
        //then
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"@sda.pl", "sda,sda@sda.pl", "@"})
    void shouldReturnFalseForInvalidEmailAddress(String input) {
        //when
        boolean result = EmailValidation.validate(input);
        //then
        assertFalse(result);
    }
}