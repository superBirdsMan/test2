package com.my.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HYSTRIX", fallback = HystrixClientFallBack.class)
public interface HystrixClient {

    @GetMapping("/demo")
    String demo(@RequestParam("id") Integer id);

}
