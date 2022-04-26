package com.chuck.common.deprecated;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * 
 * 编码工厂
 * 
 * @author Chuck
 * @since 6/18/2021
 * @version 0.0.1
 * @apiNote
 *
 **/
public class CodeUtils {
    private CodeUtils() {
    }

    private static final Random RANDOM = new Random();

    private static final String CODE_FORMAT = "yyyyMMddHHmmss";

    private static final int BOUND = 1000;

    private static String codeSuffix(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(CODE_FORMAT)) + RANDOM.nextInt(BOUND);
    }

    private static String fixedCodeSuffix(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(CODE_FORMAT)) + (int) ((Math.random() * 9 + 1) * 100);
    }

    // Public Method

    public static String code(String prefix) {
        return prefix + fixedCodeSuffix(LocalDateTime.now());
    }

    public static String code(String prefix, LocalDateTime dateTime) {
        return prefix + fixedCodeSuffix(dateTime);
    }

}
