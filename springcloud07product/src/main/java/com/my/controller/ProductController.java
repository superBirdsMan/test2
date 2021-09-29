package com.my.controller;

import com.my.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("/test4")
    public Map<String, Object> test4(Integer id) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "xiaoming1", 21.0, new Date()));
        products.add(new Product(2, "xiaoming2", 22.0, new Date()));
        products.add(new Product(3, "xiaoming3", 23.0, new Date()));
        Map<String, Object> map = new HashMap();
        map.put("total", 50);
        map.put("rows", products);
        return map;
    }

    @PostMapping("/test3")
    public String test3(@RequestPart("product") Product product) {
        log.info("product: {}", product);
        return "test2 ok " + port;
    }

    @PostMapping("/test2")
    public String test2(@RequestBody Product product) {
        log.info("product: {}", product);
        return "test2 ok " + port;
    }

    @GetMapping("/test1/{id}")
    public String test1(@PathVariable("id") Integer id) {
        log.info("id{}", id);
        return "test1 ok " + port;
    }

    @GetMapping("/test")
    public String test(String name, Integer age) throws InterruptedException {
        Thread.sleep(50000);
        log.info("name{}   age{}", name, age);
        return "test ok " + port;
    }

    @GetMapping("/product")
    public String product() throws InterruptedException {
        log.info("商品服务");
        //Thread.sleep(50000);
        return "product ok  端口： " + port;
    }
}
