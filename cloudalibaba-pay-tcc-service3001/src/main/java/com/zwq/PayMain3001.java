package com.zwq;

import com.zwq.springcloud.common.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * EnableFeignClients是说明和Feign整合
 * EnableDiscoveryClient是注册到nacos中
 * @EnableAsync 是开启异步注解功能
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAsync
public class PayMain3001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain3001.class,args);
    }
}
