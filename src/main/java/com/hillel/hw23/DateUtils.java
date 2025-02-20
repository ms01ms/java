package com.hillel.hw23;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils() {
    }

    public static String getCurrentDate(String pattern) {
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            return today.format(formatter);
    }
}
