package com.zwq.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "seata-merchants-service")
public interface MerchantsService {

    @RequestMapping("/business/businessHal")
    boolean businessHal(@RequestBody Map<String, Object> params);

}
