package com.bin;


import java.io.Serializable;

public class Test {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        JdUserService jdUserService = applicationContext.getBean("jdUserService", JdUserService.class);
//        JdUser abc = jdUserService.login("BCD", "123123");
//        System.out.println(abc);
        String x="1";
        System.out.println(x instanceof Serializable);
    }

}
