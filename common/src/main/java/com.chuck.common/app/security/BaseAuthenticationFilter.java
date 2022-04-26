package com.chuck.common.app.security;

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
 * @date: 2/23/2022 6:53 PM
 */
public class BaseAuthenticationFilter extends BasicAuthenticationFilter {

  @Autowired
  public BaseAuthenticationFilter(AuthenticationManager authenticationManager) {
    super(authenticationManager);
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    SecurityUtils.checkAuthentication(request);
    chain.doFilter(request, response);
    //    super.doFilterInternal(request, response, chain);
  }
}
