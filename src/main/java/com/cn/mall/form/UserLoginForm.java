package com.cn.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

//    @NotBlank     用户String判断空格
//    @NotEmpty     用户集合
//    @NotNull
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;


}
