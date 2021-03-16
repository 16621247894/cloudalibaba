package com.zwq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zwq.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    private OrderService orderService;


    @GetMapping("info1")
    public String info1(){
        orderService.mesage();
        return "info1";
    }

    @GetMapping("info2")
    public String info2(){
        orderService.mesage();
        return "info2";
    }




}
