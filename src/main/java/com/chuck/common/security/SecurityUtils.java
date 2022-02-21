package com.chuck.common.security;

import static com.chuck.common.security.JwtTokenUtils.AUTHORITIES;
import static com.chuck.common.security.JwtTokenUtils.CREATED;
import static com.chuck.common.security.JwtTokenUtils.PRINCIPAL;
import static com.chuck.common.security.JwtTokenUtils.USERNAME;

import com.chuck.common.security.value.BaseUserDetails;
import com.chuck.common.security.value.JwtToken;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

/**
 * @description
 * @author: Chuck
 * @date: 2/19/2022 10:46 AM
 */
public class SecurityUtils {

  public static JwtToken login(
      HttpServletRequest request,
      String username,
      String password,
      AuthenticationManager authenticationManager) {

    JwtToken token = new JwtToken(username, password);
    // 创建Session
    token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    // 执行登录认证过程
    Authentication authentication = authenticationManager.authenticate(token);
    // 认证成功存储认证信息到上下文
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // 生成令牌并返回给客户端
    BaseUserDetails jud = (BaseUserDetails) authentication.getPrincipal();

    Map<String, Object> claims = new HashMap<>(4);
    claims.put(USERNAME, username);
    claims.put(CREATED, new Date());
    claims.put(AUTHORITIES, authentication.getAuthorities());
    claims.put(PRINCIPAL, authentication.getPrincipal());

    token.setToken(JwtTokenUtils.generateToken(claims));
    return token;
  }

  /**
   * 校验令牌
   *
   * @param request
   */
  public static void checkAuthentication(HttpServletRequest request) {
    // 获取令牌并根据令牌获取登录认证信息
    Authentication authentication = JwtTokenUtils.jwtTokenFromRequest(request);
    // 设置登录认证信息到上下文
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

  /**
   * 获取当前用户名
   *
   * @return
   */
  public static String usernameFromContext() {
    Authentication authentication = authenticationFromContext();
    if (authentication == null) {
      return null;
    }
    return usernameFromAuthentication(authentication);
  }

  /**
   * 获取用户名
   *
   * @return
   */
  private static String usernameFromAuthentication(Authentication authentication) {
    if (authentication == null) {
      return null;
    }
    Object principal = authentication.getPrincipal(); // 一般就是个username
    if (principal == null) {
      return null;
    }
    if (principal instanceof String) {
      return (String) principal;
    }
    if (principal instanceof UserDetails) {
      return ((UserDetails) principal).getUsername();
    }
    return null;
  }

  /**
   * 获取当前登录信息
   *
   * @return
   */
  public static Authentication authenticationFromContext() {
    return SecurityContextHolder.getContext() == null
        ? null
        : SecurityContextHolder.getContext().getAuthentication();
  }
}
