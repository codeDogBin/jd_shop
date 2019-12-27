package com.bin.controller;

import com.bin.service.JdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JdUserController {
    @Autowired
    private JdUserService jdUserService;
    @RequestMapping("toHello")
    public String toHello(){
        return "hello";
    }
}
