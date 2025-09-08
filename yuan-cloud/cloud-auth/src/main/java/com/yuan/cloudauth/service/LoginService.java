package com.yuan.cloudauth.service;

import com.yuan.cloudauth.entity.dto.auth.LoginForm;
import com.yuan.cloudauth.entity.dto.auth.RegisterForm;

public interface LoginService {
    String login(LoginForm loginForm);

    boolean register(RegisterForm registerForm);
}
