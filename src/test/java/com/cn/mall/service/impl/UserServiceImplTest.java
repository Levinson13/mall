package com.cn.mall.service.impl;

import com.cn.mall.MallApplicationTests;
import com.cn.mall.enums.RoleEnum;
import com.cn.mall.pojo.User;
import com.cn.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    @Autowired
    private IUserService iUserService;

    @Test
    public void register(){
        User user = new User("jack1","123456","jack1@qq.com", RoleEnum.CUSTOMER.getCode());
        iUserService.register(user);

    }

}