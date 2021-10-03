package com.chuck.common.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Chuck
 * @since 6/28/2021
 * @version 0.0.1
 * @apiNote
 **/
@Configuration
@EnableJpaRepositories(basePackages = { "com.chuck.*.infrastructure.repository" })
@EntityScan(basePackages = { "com.chuck.*.domain" })
public class JpaConfig {

    // hibernateProperties

    // transactionManager

    // jpaVendorAdapter

    // entityManagerFactory

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }


}
