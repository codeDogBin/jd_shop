package com.bin.service;

import com.bin.bean.JdUser;
import com.bin.mapper.JdUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jdUserService")
public class JdUserService {
    @Autowired
    private JdUserDao jdUserDao;

    public JdUser login(String login_name,String password){
        return jdUserDao.findUser(login_name,password);
    }
}
