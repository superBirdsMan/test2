package com.my.controller;

import com.my.entity.Product;
import com.my.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category() {
        log.info("category service");

        return "category ok" + productClient.product();
    }

    @GetMapping("/test")
    public String test() {
        log.info("category service");

        return "category ok" + productClient.test("张三", 34);
    }

    @GetMapping("/test1/{id}")
    public String test1(@PathVariable("id") Integer id) {
        log.info("category service");

        return "category ok" + productClient.test1(id);
    }

    @GetMapping("/test2")
    public String test1() {
        log.info("category service");
        Product product = new Product(2, "zhangsan", 25.2, new Date());
        return "category ok" + productClient.test3(product);
    }

    @GetMapping("/test4")
    public Map test4() {
        Map<String, Object> map = productClient.test4(2);
        Object rows = map.get("rows");
        System.out.println(rows.toString());
        return map;
    }

}
