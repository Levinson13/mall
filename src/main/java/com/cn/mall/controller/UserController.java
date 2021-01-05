package com.cn.mall.controller;

import com.cn.mall.pojo.User;
import com.cn.mall.service.IUserService;
import com.cn.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.cn.mall.enums.ResponseEnum.NEED_LOGIN;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/register")
    public ResponseVo register(@RequestBody User user){
//        return ResponseVo.success();
        return ResponseVo.error(NEED_LOGIN);
    }

}
