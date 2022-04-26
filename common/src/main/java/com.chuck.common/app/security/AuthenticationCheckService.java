package com.chuck.common.app.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户认证（CRM微服务专有）
 *
 * @description
 * @author: Chuck
 * @date: 2/19/2022 11:10 AM
 */
public abstract class AuthenticationCheckService extends DaoAuthenticationProvider {

  @Override
  protected abstract void additionalAuthenticationChecks(
      UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
      throws AuthenticationException;
  /*
  {
    if (authentication.getCredentials() == null) {
      logger.debug("Authentication failed: no credentials provided");
      throw new BadCredentialsException(
          messages.getMessage(
              "AbstractUserDetailsAuthenticationProvider.badCredentials",
              "不存在的账号！（Bad credentials）"));
    }

    String presentedPassword = authentication.getCredentials().toString();
    String salt = ((JwtUserDetails) userDetails).getSalt();
    // 覆写密码验证逻辑
    if (!new EncoderUtils(salt).matches(userDetails.getPassword(), presentedPassword)) {
      logger.debug("Authentication failed: password does not match stored value");
      throw new BadCredentialsException(
          messages.getMessage(
              "AbstractUserDetailsAuthenticationProvider.badCredentials",
              "密码错误！（Bad credentials）"));
    }
  }*/
}
