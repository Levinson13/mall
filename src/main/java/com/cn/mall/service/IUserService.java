package com.cn.mall.service;

import com.cn.mall.pojo.User;

public interface IUserService {

    /**
     * 注册
     */
    void register(User user);

    /**
     * 登录
     */
    void login();
}
