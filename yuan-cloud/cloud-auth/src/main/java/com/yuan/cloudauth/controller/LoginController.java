package com.yuan.cloudauth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.yuan.cloudauth.entity.dto.auth.LoginForm;
import com.yuan.cloudauth.entity.dto.auth.RegisterForm;
import com.yuan.cloudauth.service.LoginService;
import com.yuan.cloudcommon.utils.Constants;
import com.yuan.cloudcommon.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;
    // 会话登录接口
    @GetMapping("/login")
    public Result<?> login(@RequestBody LoginForm loginForm) {
        String authentication = loginService.login(loginForm);
        if (StringUtils.isEmpty(authentication))
            return Result.fail("登录失败");
        return Result.ok(authentication,"登录成功");

    }

    //登出接口
    @GetMapping("/logout")
    public Result <?> logout() {
        StpUtil.logout();
        return Result.ok(Constants.SUCCESS,"登出成功");
    }

}
