package com.chuck.common.deprecated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 **/
public abstract class DateTimeUtils {
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String LOCAL_TIME_ZONE = "+8";

    // For String
    /**
     * 获取当前标准格式化日期时间
     *
     * @return
     */
    public static String dateTimeString() {
        return dateTimeString(LocalDateTime.now());
    }

    public static String dateTimeString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
    }

    public static String dateTimeString(LocalDateTime dateTime, String format) {
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }

    // For epoch（ 时间戳）

    public static long epochSecond(LocalDateTime dateTime) {
        return dateTime.toEpochSecond(ZoneOffset.of(LOCAL_TIME_ZONE));
    }

    // For DateTime

    public static LocalDateTime minTimeOfDate(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MIN);
    }

    public static LocalDateTime maxTimeOfDate(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.MAX);
    }

    public static LocalDateTime dateTime(long epochSecond) {
        return LocalDateTime.ofEpochSecond(epochSecond, 0, ZoneOffset.of(LOCAL_TIME_ZONE));
    }
}
