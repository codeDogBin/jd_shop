package com.bin;

import com.bin.bean.JdUser;
import com.bin.service.JdUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdUserService jdUserService = applicationContext.getBean("jdUserService", JdUserService.class);
        JdUser abc = jdUserService.login("BCD", "123123");
        System.out.println(abc);
    }

}
