package com.chuck.common.config;

import java.nio.charset.StandardCharsets;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 *
 * @author Chuck
 * @since 7/5/2021
 * @version 0.0.1
 * @apiNote
 **/
@Configuration
public class ValidatorConfig {
    /**
     * 方法参数和返回值验证：为@Validated标注的类创建代理
     * 
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidator(localValidatorFactoryBean());
        return processor;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setProviderClass(HibernateValidator.class);
        factory.setValidationMessageSource(messageSource());
        return factory;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        // messageSource.setBasenames("", "");
        return messageSource;
    }

    public static interface InsertGroup {

    }

    public static interface SelectGroup {

    }

    public static interface UpdateGroup {

    }

    public static interface DeleteGroup {

    }

}
