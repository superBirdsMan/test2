package com.my.feignclients;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallBack implements HystrixClient {

    @Override
    public String demo(Integer id) {
        return "当前服务无法使用 id ：" + id;
    }
}
