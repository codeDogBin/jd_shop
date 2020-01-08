package com.bin.controller;

import com.bin.bean.JdCategory;
import com.bin.bean.JdProduct;
import com.bin.bean.ProductPage;
import com.bin.service.JdCategoryService;
import com.bin.service.JdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;


@Controller
public class JdBookListController {
    @Autowired
    private JdCategoryService jdCategoryService;
    @Autowired
    private JdProductService jdProductService;
    /*
     * 功能描述 bookList
     * @Author bin
     * @param parent_id 当前页面的类型
     * @param request
     * @return java.lang.String
     */
    @RequestMapping("/toBookList")
    public String bookList(int parent_id, HttpServletRequest  request){
        //根据父分类获取子分类列表
        List<JdCategory> jdCategories = jdCategoryService.FindSubCategoriesByParentId(parent_id);
        request.setAttribute("jdCategories",jdCategories);
        ProductPage productPage = new ProductPage();
        //获取第一个分类的对应的ID
        int firstCategoryId =jdCategories.isEmpty()?-1:jdCategories.get(0).getCategoryId();
        productPage.setCategoryId(firstCategoryId);
        productPage.setOrderStd("print_INT");
        productPage.setOrderType("desc");
        productPage.setStartPos(0);
        productPage.setPageSize(4);
        List<JdProduct> products = jdProductService.getProductListByPageInfo(productPage);
        Integer sumCount = jdProductService.getProductCountByCategoryId(firstCategoryId);
        System.out.println(sumCount);
        int sumPages = (sumCount + 3)/4;
        System.out.println(sumPages);
        System.out.println(products);
        request.setAttribute("sumPages",sumPages);
        request.setAttribute("firstCategoryId",firstCategoryId);
        request.setAttribute("products",products);
        return  "book_list";
    }
    /*
     * 功能描述 bookListAJAX
     * @Author bin
     * @param firstCategoryId id分类对应的id
     * @param orderStd 排序标准
     * @param orderType 排序方式
     * @param startPos 分页开始位置
     * @param pageSize 一页显示多少条
     * @return    List<JdProduct>
     */
    @RequestMapping("/bookListAJAX")
    @ResponseBody
    public List<JdProduct> bookListAJAX(int firstCategoryId,
                                        String orderStd,
                                        String orderType,
                                        int startPos,
                                        int pageSize){
        //获取第一个分类的对应的ID
        ProductPage productPage = new ProductPage();
        productPage.setCategoryId(firstCategoryId);
        productPage.setOrderStd(orderStd);
        productPage.setOrderType(orderType);
        productPage.setStartPos(startPos);
        productPage.setPageSize(pageSize);
        List<JdProduct> products = jdProductService.getProductListByPageInfo(productPage);
//        Integer sumCount = jdProductService.getProductCountByCategoryId(firstCategoryId);
//        int sumPages = (sumCount + pageSize-1)/pageSize;
        return products;
    }
}
