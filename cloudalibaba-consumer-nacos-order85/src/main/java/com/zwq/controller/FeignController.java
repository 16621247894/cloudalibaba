package com.zwq.controller;

import com.zwq.service.PaymentService;
import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("getInfo/{id}")
    public CommonResult<Payment> getInfo(@PathVariable("id") Long id){
        CommonResult<Payment> commonResult=paymentService.paymentSql(id);

        return commonResult;

    }
}
