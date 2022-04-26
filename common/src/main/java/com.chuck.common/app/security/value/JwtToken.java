package com.chuck.common.app.security.value;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 如果不需要token字符串，可以不使用该对象
 *
 * @description
 * @author: Chuck
 * @date: 2/19/2022 10:47 AM
 */
@Getter
@Setter
public class JwtToken extends UsernamePasswordAuthenticationToken {

  private String token;

  public JwtToken(Object user, Object password) {
    super(user, password);
  }

  public JwtToken(Object user, Object password, String token) {
    super(user, password);
    this.token = token;
  }

  public JwtToken(
      Object user,
      Object password,
      Collection<? extends GrantedAuthority> authorities,
      String token) {
    super(user, password, authorities);
    this.token = token;
  }
}
