package pl.sdacademy.unit.test.basic.exercises.tdd.task6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayUtilTest {

    @Test
    void shouldRemoveAllDuplicates() {
        //given
        String[] array = {"Java", "Python", "Java", "C", "C#", "C"};
        //when
        String result[] = ArrayUtil.removeDuplicates(array);
        //then
        assertArrayEquals(new String[]{"Java", "Python", "C", "C#"}, result);
        assertThat(result).isEqualTo(new String[]{"Java", "Python", "C", "C#"});
    }
}