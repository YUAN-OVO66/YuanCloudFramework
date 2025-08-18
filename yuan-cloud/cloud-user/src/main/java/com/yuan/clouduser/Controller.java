package com.yuan.clouduser;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {
    @GetMapping("/info")
    public SaResult userInfo() {
        return SaResult.ok()
                .set("loginId", StpUtil.getLoginId())
                .set("roleList", StpUtil.getRoleList());
    }

}
