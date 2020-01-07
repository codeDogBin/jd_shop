package com.bin.service;

import com.bin.bean.JdCategory;
import com.bin.bean.JdProduct;
import com.bin.bean.ProductPage;
import com.bin.mapper.JdCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("jdCategoryService")
public class JdCategoryService {
    @Autowired
    private JdCategoryDao jdCategoryDao;

    /*
     * 功能描述 通过父分类拿子分类列表
     * @Author bin
     * @param parent_id 
     * @return java.util.List<com.bin.bean.JdCategory>        
     */
    public List<JdCategory> FindSubCategoriesByParentId(int parent_id){
        return jdCategoryDao.FindSubCategoriesByParentId(parent_id);
    }


}
