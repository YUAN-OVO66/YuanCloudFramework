package com.yuan.cloudauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-Auth认证中心启动成功 ----------------------");
        System.out.println();
    }
}
