package com.zwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * EnableFeignClients是说明和Feign整合
 * EnableDiscoveryClient是注册到nacos中
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain2001.class,args);
    }
}
