package com.zwq.controller;

import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();

    static{
        hashMap.put(1L,new Payment(1L,"1111111111111111111111111111"));
        hashMap.put(2L,new Payment(1L,"2222222222222222222222222222"));
        hashMap.put(3L,new Payment(1L,"3333333333333333333333333333"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment=hashMap.get(id);
        return new CommonResult<Payment>(200,"from mysql serverPort:"+serverPort,payment);

    }


}
