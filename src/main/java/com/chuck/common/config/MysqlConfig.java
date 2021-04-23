package com.chuck.common.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Chuck
 * @since 4/21/2021
 * @version 0.0.1
 *
 **/
@Configuration
// @Profile({ "mysql", "integration-db", "prod" })
@PropertySource("classpath:/mysql.yml")
@Slf4j
public class MysqlConfig {

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${userName}")
    private String userName;
    @Value("${password}")
    private String password;

    @Bean
    public DataSource dataSource() throws NamingException {
        log.info("Using Mysql DataSource");
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl(url);
        ds.setUser(userName);
        ds.setPassword(password);
        return ds;
    }

    // 作为BeanFactoryPostProcessor，定义为static方法
    // 该方法用于辅助将String转为Java对象
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
