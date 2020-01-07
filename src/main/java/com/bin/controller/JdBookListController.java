package com.bin.controller;

import com.bin.bean.JdCategory;
import com.bin.bean.JdProduct;
import com.bin.bean.ProductPage;
import com.bin.service.JdCategoryService;
import com.bin.service.JdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;


@Controller
public class JdBookListController {
    @Autowired
    private JdCategoryService jdCategoryService;
    @Autowired
    private JdProductService jdProductService;
    @RequestMapping("/toBookList")
    public String bookList(int parent_id, HttpServletRequest  request){
        List<JdCategory> jdCategories = jdCategoryService.FindSubCategoriesByParentId(parent_id);
        request.setAttribute("jdCategories",jdCategories);
        ProductPage productPage = new ProductPage();
        //获取第一个分类的对应的ID
        productPage.setCategoryId(jdCategories.isEmpty()?-1:jdCategories.get(0).getCategoryId());
        productPage.setOrderStd("print_INT");
        productPage.setOrderType("desc");
        productPage.setStartPos(1);
        productPage.setPageSize(4);
        List<JdProduct> products = jdProductService.getProductListByPageInfo(productPage);
        System.out.println(products);
        request.setAttribute("products",products);
        return  "book_list";
    }
}
