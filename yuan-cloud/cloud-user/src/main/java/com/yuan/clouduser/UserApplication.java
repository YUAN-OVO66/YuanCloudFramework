package com.yuan.clouduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-user用户中心启动成功 ----------------------");
        System.out.println();
    }
}
