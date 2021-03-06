package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     //开启告诉当前服务为一个注册中心
public class EurekaServerApplication {
    public static void main(String[] args) {

        System.out.println(4444444);
        System.out.println(333);
        System.out.println(444);
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
