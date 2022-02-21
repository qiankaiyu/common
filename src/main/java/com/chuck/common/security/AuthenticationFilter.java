package com.chuck.common.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @description
 * @author: Chuck
 * @date: 2/19/2022 3:26 PM
 */
public class AuthenticationFilter extends BasicAuthenticationFilter {

  @Autowired
  public AuthenticationFilter(AuthenticationManager authenticationManager) {
    super(authenticationManager);
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    SecurityUtils.checkAuthentication(request);
    chain.doFilter(request, response);
  }
}
