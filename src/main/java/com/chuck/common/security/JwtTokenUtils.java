package com.chuck.common.security;

import com.chuck.common.security.value.Authority;
import com.chuck.common.security.value.BaseUserDetails;
import com.chuck.common.security.value.JwtToken;
import com.chuck.common.utils.string.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * @description
 * @author: Chuck
 * @date: 2/19/2022 10:26 AM
 */
@Slf4j
public class JwtTokenUtils {
  /** 用户名称 */
  public static final String USERNAME = Claims.SUBJECT;
  /** 创建时间 */
  public static final String CREATED = "created";
  /** 权限列表 */
  public static final String AUTHORITIES = "authorities";
  /** 用户详情 */
  public static final String PRINCIPAL = "principal";
  /** 密钥 */
  private static final String SECRET = "abcdefgh";
  /** 有效期24*7小时 */
  private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

  /**
   * 生成令牌
   *
   * @param authentication 用户信息
   * @return 令牌
   */
  /*public static String generateToken(Authentication authentication) {
    Map<String, Object> claims = new HashMap<>(4);
    claims.put(USERNAME, SecurityUtils.usernameFromAuthentication(authentication));
    claims.put(CREATED, new Date());
    claims.put(AUTHORITIES, authentication.getAuthorities());
    claims.put(PRINCIPAL, authentication.getPrincipal());
    return generateToken(claims);
  }*/

  /**
   * 从数据声明生成令牌
   *
   * @param claims 数据声明
   * @return 令牌
   */
  public static String generateToken(Map<String, Object> claims) {
    Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(expirationDate)
        .signWith(SignatureAlgorithm.HS512, SECRET)
        .compact();
  }

  /**
   * 从令牌中获取用户名
   *
   * @param token 令牌
   * @return 用户名
   */
  public static String usernameFromToken(String token) {
    Claims claims = claimsFromToken(token);
    return claims.getSubject();
  }

  /**
   * 根据请求令牌获取登录认证信息
   *
   * @param request 请求
   * @return 用户名
   */
  public static Authentication jwtTokenFromRequest(HttpServletRequest request) {
    JwtToken authentication = null;
    // 获取请求携带的令牌
    String token = tokenStrFromRequest(request);
    if (token == null || isTokenExpired(token)) {
      return null;
    }

    Claims claims = claimsFromToken(token);
    if (claims == null) {
      return null;
    }
    String username = claims.getSubject();
    if (username == null) {
      return null;
    }
    Object authors = claims.get(AUTHORITIES);
    List<GrantedAuthority> authorities = new ArrayList<>();
    if (authors != null && authors instanceof List) {
      for (Object object : (List) authors) {
        authorities.add(new Authority((String) ((Map) object).get("authority")));
      }
    }
    Object userDetails = claims.get(PRINCIPAL);
    if (userDetails == null) {
      return null;
    }
    BaseUserDetails details = null;
    if (userDetails instanceof BaseUserDetails) {
      details = (BaseUserDetails) userDetails;
    }
    return new JwtToken(details, null, authorities, token);
  }

  /**
   * 获取请求token
   *
   * @param request
   * @return
   */
  public static String tokenStrFromRequest(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    String tokenHead = "Bearer ";
    if (token == null) {
      token = request.getHeader("token");
    } else if (token.contains(tokenHead)) {
      token = token.substring(tokenHead.length());
    }
    if ("".equals(token)) {
      token = null;
    }
    return token;
  }

  public static String tokenStrFromHeader(HttpHeaders headers) {
    String token =
        headers.get("Authorization").stream()
            .findFirst()
            .orElse(headers.get("token").stream().findFirst().get());
    if (StringUtils.isBlank(token)) {
      return null;
    }
    String tokenPrefix = "Bearer ";
    if (token.contains(tokenPrefix)) {
      token = token.substring(tokenPrefix.length());
    }
    return token;
  }

  /**
   * 从令牌中获取数据声明
   *
   * @param token 令牌
   * @return 数据声明
   */
  private static Claims claimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
  }

  /**
   * 验证令牌
   *
   * @param token
   * @param username
   * @return
   */
  /* public static Boolean validateToken(String token, String username) {
    String userName = usernameFromToken(token);
    return (userName.equals(username) && !isTokenExpired(token));
  }*/

  /**
   * 刷新令牌（就是更新了过期时间）
   *
   * @param token
   * @return
   */
  public static String refreshToken(String token) {
    Claims claims = claimsFromToken(token);
    claims.put(CREATED, new Date());
    String refreshedToken = generateToken(claims);
    return refreshedToken;
  }

  /**
   * 判断令牌是否过期
   *
   * @param token 令牌
   * @return 是否过期
   */
  public static boolean isTokenExpired(String token) {
    Claims claims = claimsFromToken(token);
    Date expiration = claims.getExpiration();
    return expiration.before(new Date());
  }
}
