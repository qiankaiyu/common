package com.chuck.common.domain;

import lombok.Data;

/**
 * @author Chuck
 * @since 4/22/2021
 * @version 0.0.1
 * 
 * 
 *          TODO 不使用基本类型的原因
 **/
@Data
public class Page {
    /**
     * 每页大小
     */
    private Integer pageSize;
    /**
     * 第几页，从1开始
     */
    private Integer pageNum;
}
