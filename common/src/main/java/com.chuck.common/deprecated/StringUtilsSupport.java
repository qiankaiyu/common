package com.chuck.common.deprecated;

/**
 *
 * @author Chuck
 * @since 6/19/2021
 * @version 0.0.1
 * @apiNote
 **/
public abstract class StringUtilsSupport {
    /**
     * 判空操作
     * 
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }
}
