package com.chuck.common.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chuck
 * @since 12/30/2020
 * @version
 *
 **/
@NoArgsConstructor
@Data
public class Greeting {
    private long id;

    private String content;
}
