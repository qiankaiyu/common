package com.chuck.common.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
@Profile({ "hikari", "default" })
@Slf4j
public class HikariConfig {

    public DataSource dataSource() {
        log.info("Useing HikariDataSource");
        return new HikariDataSource();
    }

}
