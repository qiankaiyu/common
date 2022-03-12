package com.chuck.common.utils.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Chuck
 * @since 8/2/2021
 * @version 0.0.1
 * @apiNote
 **/
public abstract class DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    // For Date

    public static String dateString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    public static String dateString(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

}
