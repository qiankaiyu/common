package com.chuck.common.domain;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Chuck
 * @since 1/6/2021
 * @version
 *
 **/
// @Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 不可为null
     */
    @Basic(optional = false)
    private String productName;
    /**
     * 库存
     */
    private int stock;
    /**
     * 单价
     */
    private float price;
    /**
     * 
     */
    private int version;
    /**
     * 备注
     */
    private String note;
}
