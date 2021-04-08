package com.zwq.impl;

import com.zwq.service.BusinessService;
import com.zwq.service.MerchantsService;
import com.zwq.service.PayService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class PayImpl implements PayService {

    @Autowired
    private MerchantsService merchantsService;
    // 工商银行
    @Autowired
    private BusinessService businessService;

    @Override
    @GlobalTransactional(timeoutMills = 100000000, name = "spring-cloud-pay-service")
    public boolean transfer(String merchantsId, String businessId, int amount) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        //转出账号（工商账号）
        params.put("businessId", businessId);
        //转入账号（招商账号）
        params.put("merchantsId", merchantsId);
        // 先看工商银行
        boolean answer = businessService.businessHal(params);
        if (!answer) {
            // 扣钱参与者，一阶段失败; 回滚本地事务和分布式事务
            throw new Exception("账号:[" + businessId + "] 预扣款失败!");
        }
        // 加钱参与者，一阶段执行
        answer = merchantsService.businessHal(params);
        if (!answer) {
            throw new Exception("账号:[" + merchantsId + "] 预收款失败!");
        }

        return true;
    }
}
