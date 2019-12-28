package com.bin.service;

import com.bin.bean.JdUser;
import com.bin.mapper.JdUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jdUserService")
public class JdUserService {
    @Autowired
    private JdUserDao jdUserDao;
    /*
     * 功能描述 login
     * @Author Libin
     * @param login_name
     * @param password
     * @return com.bin.bean.JdUser        
     */
    public JdUser login(String login_name,String password){
        return jdUserDao.findUser(login_name,password);
    }
    /*
     * 功能描述 insertOne
     * @Author Libin
     * @param jdUser 
     * @return int        
     */
    public boolean insertOne(JdUser jdUser){
        System.out.println(jdUser);
        try {
            return jdUserDao.insertUser(jdUser)==1?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
