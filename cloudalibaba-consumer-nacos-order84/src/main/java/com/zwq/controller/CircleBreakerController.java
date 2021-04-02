package com.zwq.controller;

import com.zwq.springcloud.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircleBreakerController {

    private static final String SERVICE_URL="http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    public CommonResult fallback(@PathVariable Long id){
        return null;
    }

}
