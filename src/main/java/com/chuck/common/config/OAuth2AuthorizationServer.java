//package com.chuck.common.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Chuck 12/10/21 17:54
// */
//@Configuration
//@EnableAuthorizationServer
//public class OAuth2AuthorizationServer extends  AuthorizationServerConfigurerAdapter{
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//            .tokenKeyAccess("permitAll()")
//            .checkTokenAccess("isAuthenticated()")
//            .allowFormAuthenticationForClients();
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//            .inMemory()
//            .withClient("clientapp")
//            .secret(passwordEncoder.encode("123456"))
//            .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//            .authorities("READ_ONLY_CLIENT")
//            .scopes("read_profile_info")
//            .resourceIds("oauth2-resource")
//            .redirectUris("http://localhost:8081/login")
//            .accessTokenValiditySeconds(5000)
//            .refreshTokenValiditySeconds(50000);
//    }
//}
