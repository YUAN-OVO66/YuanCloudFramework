package com.yuan.cloudauth.entity.dto.auth;


import lombok.Data;

@Data
public class RegisterForm {

    Long username;// 用户名

    String password;// 密码

    String rePassword;// 确认密码

}
