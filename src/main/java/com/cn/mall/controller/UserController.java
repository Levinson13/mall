package com.cn.mall.controller;

import com.cn.mall.consts.MallConsts;
import com.cn.mall.form.UserLoginForm;
import com.cn.mall.form.UserRegisterForm;
import com.cn.mall.pojo.User;
import com.cn.mall.service.IUserService;
import com.cn.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.cn.mall.enums.ResponseEnum.PARAM_ERROR;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/user/register")
    public ResponseVo register(@Valid  @RequestBody UserRegisterForm userForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            log.info("注册提交的参数有误,{}",bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        User user = new User();
        BeanUtils.copyProperties(userForm,user);
        return iUserService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  BindingResult bindingResult,
                                  HttpSession session){
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        ResponseVo<User> userResponseVo = iUserService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        // 设置Session
        session.setAttribute(MallConsts.CURRENT_USER, userResponseVo.getData());

        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo userInfo(HttpSession session){
        User user = (User) session.getAttribute(MallConsts.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        session.removeAttribute(MallConsts.CURRENT_USER);
        return ResponseVo.success();
    }

}
