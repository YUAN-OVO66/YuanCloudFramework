package com.yuan.cloudai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-AI核心启动成功 ----------------------");
        System.out.println();
    }
}
