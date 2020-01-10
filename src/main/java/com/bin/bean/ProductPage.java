package com.bin.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 功能描述 用来分页
 * @Author bin
 * @param null 
 * @return         
 */
@Setter
@Getter
@ToString
public class ProductPage {
    private Integer categoryId;
    private String orderStd;
    private String orderType;
    private Integer startPos;
    private Integer pageSize;

}
