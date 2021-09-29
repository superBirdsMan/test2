package com.my.controller;

import com.my.feignclients.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDemoController {

    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("test/{id}")
    public String test(@PathVariable("id") Integer id) {
        String demoResult = hystrixClient.demo(id);
        System.out.println("test ok" + demoResult);
        return "test ok" + demoResult;
    }


}
