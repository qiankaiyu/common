package com.chuck.common.config;

import com.chuck.common.utils.file.config.StorageProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author Chuck
 * @since 7/5/2021
 * @version 0.0.1
 * @apiNote
 */
// @Configuration
@EnableWebMvc
@EnableTransactionManagement(
    mode = AdviceMode.PROXY,
    proxyTargetClass = false,
    order = Ordered.LOWEST_PRECEDENCE)
public class ContextConfig implements WebMvcConfigurer {

  @Resource @Setter private SpringValidatorAdapter validator;

  @Resource @Setter private ObjectMapper objectMapper;

  @Value("${com.chuck.fileLocation}")
  private String fileLocation;

  @Autowired private StorageProperties storageProperties;

  /** 替代SpringMVC自行创建的Validator实例，用于表单对象参数的验证 */
  @Override
  public Validator getValidator() {
    return this.validator;
  }

  /** 仅支持Json的MessageConverters */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new SourceHttpMessageConverter<>());
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    jsonConverter.setSupportedMediaTypes(
        Arrays.asList(new MediaType("application", "json"), new MediaType("text", "json")));
    jsonConverter.setObjectMapper(this.objectMapper);
    converters.add(jsonConverter);
    converters.add(new ResourceHttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.defaultContentType(MediaType.APPLICATION_JSON);
  }

  //    @Bean
  //    public LocaleResolver localeResolver() {
  //        return new AcceptHeaderLocaleResolver();
  //    }

  //    @Override
  //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //
  // registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources/"
  // );
  //        registry.addResourceHandler("/files/**").addResourceLocations("classpath:/static/" );
  //    缓存静态内容
  //
  // registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources/"
  // ).setCachePeriod(365*24*60*60);
  //    启用Gzip压缩
  //
  // registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources/"
  // ).resourceChain(true).addResolver(new GzipResourceResolver()).addResolver(new
  // PathResourceResolver());
  //    }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper helper = new UrlPathHelper();
    helper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(helper);
  }

  //    @Override
  //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //
  // registry.addResourceHandler(ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
  //            .toUriString()).addResourceLocations("file:"+storageProperties.getFileLocation());
  //    }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

    registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
  }
}
