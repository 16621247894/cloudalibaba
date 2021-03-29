package com.zwq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwq.cloud.myhandler.CustomerBlockHandler;
import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    /**
     * 按照资源名来进行限流，降级。
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() throws Exception {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "emp001"));
    }


    public CommonResult handleException(BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getCanonicalName() + " 服务不可用");
    }

    /**
     * 按照url,经过测试结论:不能按照/byUrl来进行限流降级，不会调用降级方法的（只会调用默认的），只有按照资源名 也就是byUrl限流，
     * 才会调用降级方法。
     *
     * @return
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleException")
    public CommonResult byUrl() {
        return new CommonResult(200, "xxx按照url来进行限流OK", new Payment(1L, "xxx1"));
    }

    /**
     * 客户自定义降级方法，全局统一的。
     *
     * @return
     */
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlderException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "xxx按照url来进行限流OK", new Payment(1L, "xxx1"));
    }

}
