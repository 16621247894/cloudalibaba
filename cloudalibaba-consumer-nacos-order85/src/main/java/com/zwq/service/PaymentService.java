package com.zwq.service;

import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);


}
