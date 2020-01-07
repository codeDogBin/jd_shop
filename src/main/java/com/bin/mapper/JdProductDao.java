package com.bin.mapper;

import com.bin.bean.JdProduct;
import com.bin.bean.ProductPage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JdProductDao {
    @Select("select jp.* from jd_product jp, jd_category_product jcp where " +
            "jp.product_id=jcp.product_id and jcp.category_id= #{categoryId} " +
            " order by ${orderStd} ${orderType} limit #{startPos},#{pageSize}")
    List<JdProduct> getProductListByPageInfo(ProductPage productPage);
}
