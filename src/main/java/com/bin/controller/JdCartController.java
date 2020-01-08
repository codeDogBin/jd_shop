package com.bin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JdCartController {
    @RequestMapping("initCart")
    public String initCart(){
        return "initCart";
    }
}
