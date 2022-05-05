package com.chuck.common.config.sample;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @author: Chuck
 * @date: 4/28/2022 11:36 AM
 */
// @Configuration
@EnableWebMvc
public class StaticConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    /*    registry
    .addResourceHandler("swagger-ui.html")
    .addResourceLocations("classpath:/META-INF/resources/");*/

    registry
        .addResourceHandler("webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
  }
}
