package com.chuck.common.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/22/2021
 * @version 0.0.1
 *
 **/
@Configuration
@PropertySource("classpath:/jpa.yml")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.chuck.common.repository" })
@Slf4j
public class JPAConfig {

    private static final String DOMAIN_PACKAGE = "com.chuck.common.domain.*";

    // hibernate叫Session，JPA叫EntityManager
    // @Bean
    // public LocalSessionFactoryBean sessionFactory(DataSource ds) {
    // log.info("Using Hibernate SessionFactory");
    // LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    // factory.setDataSource(ds);
    // factory.setPackagesToScan(DOMAIN_PACKAGE);
    // return factory;
    // }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        log.info("Using Hibernate SessionFactory");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(ds);
        factory.setPackagesToScan(DOMAIN_PACKAGE);
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, String> map = new HashMap<>();
        map.put("hibernate.show_sql", "true");
        map.put("hibernate.id.new_generator_mapping", "false");
        factory.setJpaPropertyMap(map);
        return factory;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
