package com.chuck.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 **/
public abstract class DateTimeUtils {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     * 
     * @return
     */
    public static String getDateTime() {
        return getDateTime(LocalDateTime.now());
    }

    /**
     * 标准格式化日期时间
     * 
     * @param date
     * @return
     */
    public static String getDateTime(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_FORMAT));
    }
}
