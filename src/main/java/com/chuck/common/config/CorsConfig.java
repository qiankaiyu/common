package com.chuck.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Chuck
 * @since 7/6/2021
 * @version 0.0.1
 * @apiNote
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .exposedHeaders("token")
        .allowedOriginPatterns("*")
        .allowedMethods("HEAD", "POST", "GET", "PUT", "OPTIONS", "DELETE", "PATCH")
        .maxAge(168000)
        .allowedHeaders("*")
        .allowCredentials(true);
  }
}
