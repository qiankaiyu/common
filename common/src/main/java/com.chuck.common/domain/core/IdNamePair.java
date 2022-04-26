package com.chuck.common.domain.core;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 唯一标识的值对象
 *
 * @author Chuck
 * @version 0.0.1
 * @apiNote Value Object
 * @since 7/9/2021
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Deprecated
public class IdNamePair {

    /**
     * 值对象标识主键
     */
    @DecimalMin(value = "1")
    private Integer id;
    /**
     * 值对象标识名称
     */
    private String name;

    public IdNamePair(Integer id) {
        this.setId(id);
    }
}
