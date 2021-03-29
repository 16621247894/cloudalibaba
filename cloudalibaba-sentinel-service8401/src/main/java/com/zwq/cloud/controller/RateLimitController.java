package com.zwq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() throws Exception{
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "emp001"));
    }


    public CommonResult handleException(BlockException blockException){
        return new CommonResult(444,blockException.getClass().getCanonicalName()+" 服务不可用");
    }



}
