package com.mmc.statistic.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @author: Chuck
 * @date: 5/5/2022 2:05 PM
 */
@Configuration
public class LocalDateFormatConfig implements WebMvcConfigurer {

  private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

  private static final String DATE_PATTERN = "yyyy-MM-dd";

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new LocalDateConverter(DATE_PATTERN));
    registry.addConverter(new LocalDateTimeConverter(DATE_TIME_PATTERN));
  }

  private final class LocalDateConverter implements Converter<String, LocalDate> {

    private final DateTimeFormatter formatter;

    private LocalDateConverter(String pattern) {
      this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDate convert(String source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return LocalDate.parse(source, formatter);
    }
  }

  private final class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private final DateTimeFormatter formatter;

    private LocalDateTimeConverter(String pattern) {
      this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDateTime convert(String source) {
      if (source == null || source.isEmpty()) {
        return null;
      }
      return LocalDateTime.parse(source, formatter);
    }
  }
}
