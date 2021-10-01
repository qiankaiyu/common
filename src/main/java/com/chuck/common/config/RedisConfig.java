package com.chuck.common.config;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Chuck
 * @since 8/9/2021
 * @version 0.0.1
 * @apiNote Value Object
 **/
@Configuration
public class RedisConfig {

    // @Bean
    // public JedisConnectionFactory connectionFactory() {
    // JedisConnectionFactory factory = new JedisConnectionFactory();
    // // factory.setHostName();
    // // factory.serPort();
    // return factory;
    // }

    // @Bean
    // public RedisTemplate redisTemplate() {
    // return new RedisTemplate(connectionFactory());
    // }

    // 1、使用例子
    // String key;
    // ValueOperations<String,Long> values=redis.opsForValue();
    // values.setIfAbsent(key,0L);
    // values.increment(key,1);

}
