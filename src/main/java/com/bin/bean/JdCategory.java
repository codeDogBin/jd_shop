package com.bin.bean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/**
 * 描述产品的类型的类
 */
@Setter
@Getter
@ToString
public class JdCategory implements Serializable {
    private Integer categoryId;
    private String name;
    private Integer  turn;
    private String	description;
    private Integer parentId;
}
