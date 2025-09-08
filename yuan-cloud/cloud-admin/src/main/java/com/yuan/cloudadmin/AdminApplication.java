package com.yuan.cloudadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-Admin启动成功 ----------------------");
        System.out.println();
    }
}
