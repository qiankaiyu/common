//package com.chuck.common.config;
//
//import org.springframework.context.annotation.Configuration;
//
///**
// * Chuck 12/10/21 17:52
// */
//@Configuration
//@EnableResourceServer
//public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter{
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .antMatchers("/").permitAll()
//            .antMatchers("/api/v1/**").authenticated();
//    }
//}
