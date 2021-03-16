package com.zwq.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @SentinelResource("mesage")
    public void mesage(){
        System.out.println("获取的message");
    }
}
