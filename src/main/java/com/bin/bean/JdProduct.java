package com.bin.bean;

import jdk.nashorn.internal.scripts.JD;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 功能描述 商品
 * @Author bin
 * @return
 */
@Setter
@Getter
@ToString
public class JdProduct implements Serializable {
    private Integer productId;
    private String name;
    private String keywords;
    private Timestamp addTime;
    private String picture;
    private String bigPicture;
    private double fixedPrice;
    private double lowerPrice;
    private String description;
    private String author;
    private String publishing;
    private Timestamp publishTime;
    private String isbn;
    private String language;
    private String whichEdtion;
    private String totalPage;
    private String bindLayout;
    private String bookSize;
    private String editorDescription;
    private String catalog;
    private String bookSummary;
    private String authorSummary;
    private String extracts;
    private Timestamp printTime;
    private Integer printInt;
    private String paperType;
    private String printFrequency;

    public JdCartItem converToCartIter(){
        JdCartItem item = new JdCartItem();
        item.setProductId(productId);
        item.setPicture(picture);
        item.setName(name);
        item.setLowerPrice(lowerPrice);
        item.setProductCount(1);
        item.setScore(0);
        item.setBackMoney(0.0);
        return item;
    }

}
