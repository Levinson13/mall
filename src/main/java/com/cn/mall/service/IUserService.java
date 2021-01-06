package com.cn.mall.service;

import com.cn.mall.pojo.User;
import com.cn.mall.vo.ResponseVo;

public interface IUserService {

    /**
     * 注册
     */
    ResponseVo<User> register(User user);

    /**
     * 登录
     */
    ResponseVo<User> login(String username,String password);
}
