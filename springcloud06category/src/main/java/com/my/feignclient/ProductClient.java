package com.my.feignclient;

import com.my.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//调用商品服务接口
//value:调用服务的ID
@FeignClient(value = "PRODUCT")
public interface ProductClient {


    @GetMapping("/test4")
    public Map<String, Object> test4(@RequestParam("id") Integer id);

    //数组
    @PostMapping("/test3")
    String test3(@RequestPart("product") Product product);

    //json
    @PostMapping("/test2")
    String test2(@RequestBody Product product);

    //路径变量
    @GetMapping("/test1/{id}")
    public String test1(@PathVariable("id") Integer id);

    //参数
    @GetMapping("/test")
    public String test(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @GetMapping("/product")
    String product();

}
