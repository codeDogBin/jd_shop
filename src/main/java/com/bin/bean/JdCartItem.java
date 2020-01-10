package com.bin.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Setter
@Getter
@ToString
public class JdCartItem {
    private int productId;
    private String picture;
    private String name;
    private double lowerPrice;
    private double backMoney;
    private double score;
    private int productCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JdCartItem that = (JdCartItem) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
