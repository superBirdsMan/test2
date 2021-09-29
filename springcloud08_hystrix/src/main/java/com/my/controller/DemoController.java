package com.my.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {

    @GetMapping("/demo")
    @HystrixCommand(fallbackMethod = "demoFallbackMethod", defaultFallback = "defaultFallbackMethod") //熔断后的处理方法
    public String demo(Integer id) {
        System.out.println("demo ok");
        if (id <= 0) {
            throw new RuntimeException("无效id");
        }
        return "demo ok";
    }

    public String demoFallbackMethod(Integer id) {
        return "当前活动过于火爆，服务被熔断";
    }

    public String defaultFallbackMethod(Integer id) {
        return "网络连接失败!";
    }

}
