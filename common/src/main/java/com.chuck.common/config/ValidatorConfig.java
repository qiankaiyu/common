package com.chuck.common.config;

import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Chuck
 * @since 7/5/2021
 * @version 0.0.1
 * @apiNote
 **/
@Configuration
public class ValidatorConfig implements WebMvcConfigurer {

    @Resource
    @Setter
    private SpringValidatorAdapter validator;
    /** 替代SpringMVC自行创建的Validator实例，用于表单对象参数的验证 */
    @Override
    public Validator getValidator() {
        return this.validator;
    }
    /**
     * 方法参数和返回值验证：为@Validated标注的类创建代理
     * 
     * @return
     */
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
//        processor.setValidator(localValidatorFactoryBean());
//        return processor;
//    }

//    @Bean
//    public LocalValidatorFactoryBean localValidatorFactoryBean() {
//        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
//        factory.setProviderClass(HibernateValidator.class);
//        factory.setValidationMessageSource(messageSource());
//        return factory;
//    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        // messageSource.setBasenames("", "");
        return messageSource;
    }

}
