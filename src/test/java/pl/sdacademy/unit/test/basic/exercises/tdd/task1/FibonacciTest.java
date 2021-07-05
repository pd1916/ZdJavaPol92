package pl.sdacademy.unit.test.basic.exercises.tdd.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    private static Fibonacci fibonacci;

    @BeforeAll
    static void init() {
        fibonacci = new Fibonacci();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void shouldReturnTheSameValueAsInput(int input) {
        //when
        int result = fibonacci.getValueFromIndex(input);
        //then
        assertEquals(input, result);
        assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @MethodSource("provideData")
    void shouldReturnCorrectValue(int input, int expected) {
        //when
        int result = fibonacci.getValueFromIndex(input);
        //then
        assertEquals(expected, result);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(4, 3),
                Arguments.of(6, 8),
                Arguments.of(8, 21)
        );
    }
}