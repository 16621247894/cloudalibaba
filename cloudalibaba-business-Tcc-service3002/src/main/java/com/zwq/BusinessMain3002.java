package com.zwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 工商银行
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessMain3002 {
    public static void main(String[] args) {
        SpringApplication.run(BusinessMain3002.class,args);

    }

}
