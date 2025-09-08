package com.yuan.cloudauth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import com.yuan.cloudauth.entity.dto.auth.LoginForm;
import com.yuan.cloudauth.entity.dto.auth.RegisterForm;
import com.yuan.cloudauth.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(LoginForm loginForm) {
        if(loginPreCheck(loginForm.getUsername(), loginForm.getPassword())){
            // 登录成功
            loginRecord(loginForm.getUsername());
            StpUtil.login(loginForm.getUsername());
            return StpUtil.getTokenValue();
        }
        return null;
    }

    @Override
    public boolean register(RegisterForm registerForm) {
        return false;
    }

    /*
    * 登录前校验
    * */
    public Boolean loginPreCheck(String username, String password){
        return true;
    }

    /*
    * 登录记录
    * */
    public void loginRecord(String username){

    }
}
