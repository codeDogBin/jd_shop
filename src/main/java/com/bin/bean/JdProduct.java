package com.bin.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
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
}
