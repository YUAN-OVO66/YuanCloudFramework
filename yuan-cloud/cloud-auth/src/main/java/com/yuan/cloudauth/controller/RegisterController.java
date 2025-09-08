package com.yuan.cloudauth.controller;

import com.yuan.cloudauth.entity.dto.auth.RegisterForm;
import com.yuan.cloudauth.service.LoginService;
import com.yuan.cloudcommon.utils.Constants;
import com.yuan.cloudcommon.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {

    private LoginService loginService;

    //注册接口
    @PostMapping("/register")
    public Result<?> register(@RequestBody RegisterForm registerForm) {
        if (loginService.register(registerForm))
            return Result.ok(Constants.SUCCESS,"注册成功");
        return Result.fail("注册失败");
    }
}
