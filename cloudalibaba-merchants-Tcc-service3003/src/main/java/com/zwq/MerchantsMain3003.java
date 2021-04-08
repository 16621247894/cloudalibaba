package com.zwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 招商银行
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MerchantsMain3003 {
    public static void main(String[] args) {
        SpringApplication.run(MerchantsMain3003.class,args);

    }
}
