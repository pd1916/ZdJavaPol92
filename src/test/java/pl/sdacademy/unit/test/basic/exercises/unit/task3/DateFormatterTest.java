package pl.sdacademy.unit.test.basic.exercises.unit.task3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateFormatterTest {

    @Test
    void shouldReturnFormatDateToYearDayMonth() {
        //given
        String expectedDate = "1990-02-01";
        LocalDate inputDate = LocalDate.of(1990, 1, 2);
        DateFormatter dateFormatter = new DateFormatter();
        //when
        String result = dateFormatter.formatDate(inputDate);
        //then
        assertEquals(expectedDate, result); //JUnit5
        assertThat(result).isEqualTo(expectedDate); //AssertJ
    }

}