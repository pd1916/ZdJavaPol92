package pl.sdacademy.unit.test.basic.exercises.tdd.task2;

public class StringUtilWithParameterized {

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}