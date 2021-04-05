package com.zwq.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircleBreakerController {

    private static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("payment/{id}")
    //fallback是执行程序异常走的兜底方法
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    //blockHandler 负责的是sentinel配置违规
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")
    // exceptionsToIgnore是忽略异常
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback",
    exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult fallback(@PathVariable Long id) {

        CommonResult<Payment> commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException ,非法参数问题");
        } else if (commonResult.getData() == null) {
            throw new NullPointerException("NullPointerException,id没有记录,空指针异常");
        }


        return commonResult;
    }

    /**
     * Throwable必须是  不能是Exception  本例子是fallback
     * 当服务提供者挂了的时候 会走异常的fallback
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "异常兜底方法handlerFallback内容" + e.getMessage(), payment);
    }

    /**
     * 例子是sentinel配置违规
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(455, "BlockException限流无此流水,sentinel限流" + e.getMessage(), payment);
    }

}
