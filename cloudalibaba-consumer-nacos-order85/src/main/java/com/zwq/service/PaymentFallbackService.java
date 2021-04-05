package com.zwq.service;

import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * 当nacos-payment-provider服务提供者 挂了的时候会走这个兜底方法,抛出异常的时候也会走
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444, "PaymentFallbackService异常降级,", new Payment(id, "error"));
    }
}
