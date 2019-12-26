package com.bin.mapper;

import com.bin.bean.JdUser;
import org.apache.ibatis.annotations.Param;

public interface JdUserDao {

    JdUser findUser(@Param("login_name") String login_name,
                    @Param("password") String password);

}