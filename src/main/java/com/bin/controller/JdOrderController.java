package com.bin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 功能描述
 * @Author bin
 * @param null
 * @return
 */

@Controller
public class JdOrderController {
    @RequestMapping("/orderInfoSure")
    public String orderInfoSure(){
        return "orderInfoSure";
    }
}
