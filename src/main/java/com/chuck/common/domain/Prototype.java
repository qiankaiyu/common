package com.chuck.common.domain;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/21/2021
 * @version 0.0.1
 *
 **/
@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// @Profile("spring-depends-test")
@Slf4j
public class Prototype {
    public Prototype() {
        log.info("{}构造器调用", Prototype.class.getName());
    }
}
