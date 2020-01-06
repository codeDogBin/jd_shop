package com.bin.controller;

import com.bin.bean.JdCategory;
import com.bin.service.JdCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class JdBookListController {
    @Autowired
    private JdCategoryService jdCategoryService;
    @RequestMapping("/toBookList")
    public String bookList(int parent_id, HttpServletRequest  request){
        List<JdCategory> jdCategories = jdCategoryService.FindSubCategoriesByParentId(parent_id);
        request.setAttribute("jdCategories",jdCategories);
        return  "book_list";
    }

}
