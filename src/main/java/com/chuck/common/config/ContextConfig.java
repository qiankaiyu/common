package com.chuck.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import lombok.Setter;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 *
 * @author Chuck
 * @since 7/5/2021
 * @version 0.0.1
 * @apiNote
 **/
@Configuration
@EnableWebMvc
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false, order = Ordered.LOWEST_PRECEDENCE)
public class ContextConfig implements WebMvcConfigurer {

    @Resource
    @Setter
    private SpringValidatorAdapter validator;

    /**
     * 替代SpringMVC自行创建的Validator实例，用于表单对象参数的验证
     */
    @Override
    public Validator getValidator() {
        return this.validator;
    }

    @Resource
    @Setter
    private ObjectMapper objectMapper;

    /**
     * 仅支持Json的MessageConverters，重载该方法将会去除之前所有预置的Convert（
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new SourceHttpMessageConverter<>());
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        jsonConverter.setSupportedMediaTypes(
//                Arrays.asList(new MediaType("application", "json"), new MediaType("text", "json")));
//        jsonConverter.setObjectMapper(this.objectMapper);
//        converters.add(jsonConverter);
//    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Bean
    public LocaleResolver localResolver(){
        return new AcceptHeaderLocaleResolver();
    }
}
