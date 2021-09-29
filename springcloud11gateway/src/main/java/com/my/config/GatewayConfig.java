package com.my.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    //@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product_route", r -> r.path("/product/**")
                        .uri("http://localhost:8788"))
                .route("category_route", r -> r.path("/category/**")
                        .uri("http://localhost:8787"))
                .build();
    }
}
