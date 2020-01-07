package com.bin.service;

import com.bin.bean.JdProduct;
import com.bin.bean.ProductPage;
import com.bin.mapper.JdProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("jdProductService")
public class JdProductService {
    @Autowired
    private JdProductDao jdProductDao;
    /*
     * 功能描述 根据页面上的信息获取产品列表
     * @Author bin
     * @param productPage 
     * @return java.util.List<com.bin.bean.JdProduct>        
     */
    public List<JdProduct> getProductListByPageInfo(ProductPage productPage){
       return jdProductDao.getProductListByPageInfo(productPage);
    }
}
