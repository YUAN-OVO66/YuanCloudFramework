package com.yuan.cloudauth;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.yuan.cloudcommon.utils.Constants;
import com.yuan.cloudcommon.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Controller {
    // 会话登录接口
    @GetMapping("/login")
    public Result<?> doLogin(String name, String pwd) {
        // 第一步：比对前端提交的账号名称、密码
        if("1".equals(name) && "1".equals(pwd)) {
            // 第二步：根据账号id，进行登录
            StpUtil.login(10001);
            return Result.ok(StpUtil.getTokenValue(),"登录成功");
        }
        return Result.fail("登录失败");
    }

    //登出接口
    @GetMapping("/logout")
    public Result <?> logout() {
        StpUtil.logout();
        return Result.ok(Constants.SUCCESS,"登出成功");
    }
}
