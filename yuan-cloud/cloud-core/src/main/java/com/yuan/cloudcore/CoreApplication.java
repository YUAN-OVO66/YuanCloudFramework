package com.yuan.cloudcore;

import org.dromara.x.file.storage.spring.EnableFileStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFileStorage
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-Core核心启动成功 ----------------------");
        System.out.println();
    }


}
