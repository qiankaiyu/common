package com.chuck.common.app.security.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @description
 * @author: Chuck
 * @date: 2/19/2022 11:07 AM
 */
@Data
@AllArgsConstructor
public class Authority implements GrantedAuthority {

    /**
     * 使用角色名称表示Authority（权限）
     */
    private String authority;
}
