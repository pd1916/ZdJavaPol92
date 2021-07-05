package pl.sdacademy.unit.test.basic.exercises.unit.task4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ConverterNaturalNumberTest {

    private static ConverterNaturalNumber converterNaturalNumber;
    private static final int FIRST_NATURAL_NUMBER = 0;

    @BeforeAll
    static void init() {
        converterNaturalNumber = new ConverterNaturalNumber();
    }

    @Test
    void shouldReturnStringFromNumberIfNumberIsGreaterThanZero() {
        //given
        int i = FIRST_NATURAL_NUMBER + 1;
        //when
        String result = converterNaturalNumber.toStringFromNaturalNumber(i);
        //then
        assertEquals("1", result);
        assertThat(result).isEqualTo("1");
    }

    @Test
    void shouldReturnStringFromNumberIfNumberIsEqualZero() {
        //when
        String result = converterNaturalNumber.toStringFromNaturalNumber(0);
        //then
        assertEquals("0", result);
        assertThat(result).isEqualTo("0");
    }

    @Test
    void shouldThrowExceptionIfNumberIsLessThanZero() {
        //given
        int i = FIRST_NATURAL_NUMBER - 1;
        //when
        //#Option1 - junit5
        try {
            converterNaturalNumber.toStringFromNaturalNumber(i);
            fail();
        } catch (IllegalArgumentException ex) {
            assertThat(ex).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Given number is less that 0!");
        }

        //#Option2 -junit5
        assertThrows(IllegalArgumentException.class,
                () -> converterNaturalNumber.toStringFromNaturalNumber(i), "Given number is less that 0!");

        //#Option3 - assertJ
        assertThatThrownBy(() -> converterNaturalNumber.toStringFromNaturalNumber(i))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Given number is less that 0!");
    }
}