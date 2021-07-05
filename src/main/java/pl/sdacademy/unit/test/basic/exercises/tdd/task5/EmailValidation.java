package pl.sdacademy.unit.test.basic.exercises.tdd.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    public static final Pattern VALID_EMAIL_ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_PATTERN.matcher(emailStr);
        return matcher.find();
    }
}