package com.bin.controller;

import com.bin.bean.JdUser;
import com.bin.service.JdUserService;
import com.bin.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JdUserController {
    @Autowired
    private JdUserService jdUserService;
    @RequestMapping("/toHello")
    public String toHello(){
        return "hello";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/toRegister")
    public  String toRegister(){
        return "register";
    }
 /*
  * 功能描述 login
  * @Author Libinz
  * @param loginName
  * @param password 
  * @return java.lang.String        
  */
    @RequestMapping("/login")
    public String login(String loginName, String password, HttpServletRequest request){
        password = Md5Util.md5StrAndSalt(password,loginName);
        JdUser jdUser = jdUserService.login(loginName, password);
        if(jdUser != null){
            request.getSession().setAttribute("jdUser",jdUser);
            return "book";
        }
        request.setAttribute("msg","登陆失败");
        return "login";
    }
    /*
     * 功能描述
     * @Author Libin
     * @param null
     * @return
     */
     @RequestMapping("/register")
    public String register(JdUser jdUser ,HttpServletRequest request){
         jdUser.setPassword(Md5Util.md5StrAndSalt(jdUser.getPassword(),jdUser.getLoginName()));
         boolean rs = jdUserService.insertOne(jdUser);
         if(!rs){
            request.setAttribute("msg","注册失败");
            return "register";
        }
        return "registerOk";
    }



}
