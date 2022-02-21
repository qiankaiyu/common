package com.chuck.common.security.value;

import java.util.Collection;
import java.util.Set;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 认证用户信息
 *
 * @description
 * @author: Chuck
 * @date: 2/19/2022 10:57 AM
 */
@Data
public class BaseUserDetails implements UserDetails {

    private String username;

    private String password;

    private String salt;

    private Set<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
