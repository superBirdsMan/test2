package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")

    public String invokeDemo() {
        log.info("User demo..");
//        RestTemplate restTemplate = new RestTemplate();
//        String orderResult = restTemplate.getForObject("http://localhost:9999/order", String.class);

        //使用ribbon组件+restTemplate实现负载均衡调用   1.DiscoveryClient  2.LoadBalanceClient   3.@LoadBalance
//          List<ServiceInstance> serviceInstances = discoveryClient.getInstances("ORDERS");
//        serviceInstances.forEach((serviceInstance) -> {
//            log.info("服务器主机 ：{}  服务端口{}  服务地址{}", serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
//        });
//        String result = new RestTemplate().getForObject(serviceInstances.get(0).getUri() + "/order", String.class);
//        log.info("调用订单服务成功：：" + orderResult);

        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");
        log.info("服务器主机 ：{}  服务端口{}  服务地址{}", serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri());
        String result = new RestTemplate().getForObject(serviceInstance.getUri() + "/order", String.class);
        return "调用order成功：" + result;
//        String result = restTemplate.getForObject("http://ORDERS/order", String.class);
//        return "调用order成功：" + result;
    }
}








