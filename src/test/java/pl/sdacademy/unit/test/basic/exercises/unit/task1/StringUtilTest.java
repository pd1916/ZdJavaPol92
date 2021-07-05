package pl.sdacademy.unit.test.basic.exercises.unit.task1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

    @Test
    void shouldReturnTrueIfStringIsEmpty() {
        //given
        String input = "";
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertTrue(result); //JUnit5
        assertThat(result).isTrue(); //AssertJ
    }

    @Test
    void shouldReturnTrueIfStringContainsOnlySpaces() {
        //given
        String input = " ";
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertTrue(result); //JUnit5
        assertThat(result).isTrue(); //AssertJ
    }

    @Test
    void shouldReturnFalseIfStringIsNotEmptyTest1() {
        //given
        String input = "a";
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result); //JUnit5
        assertThat(result).isFalse(); //AssertJ
    }

    @Test
    void shouldReturnFalseIfStringIsNotEmptyTest2() {
        //given
        String input = " a";
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result); //JUnit5
        assertThat(result).isFalse(); //AssertJ
    }

    @Test
    void shouldReturnFalseIfStringIsNotEmptyTest3() {
        //given
        String input = "a ";
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result); //JUnit5
        assertThat(result).isFalse(); //AssertJ
    }

    @Test
    void shouldReturnFalseIfStringIsNotEmptyTest4() {
        //given
        String input = " a ";
        //when
        boolean result = StringUtil.isBlank(input);
        //then
        assertFalse(result); //JUnit5
        assertThat(result).isFalse(); //AssertJ
    }
}