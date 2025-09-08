package com.yuan.cloudcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-Core核心启动成功 ----------------------");
        System.out.println();
    }


}
