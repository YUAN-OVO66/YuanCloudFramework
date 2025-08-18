package com.yuan.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println();
        System.out.println("----------------------Cloud-Gateway网关启动成功 ----------------------");
        System.out.println();
    }
}
