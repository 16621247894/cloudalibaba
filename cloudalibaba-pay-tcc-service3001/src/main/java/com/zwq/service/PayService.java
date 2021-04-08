package com.zwq.service;

import org.springframework.stereotype.Service;

@Service
public interface PayService {
    public boolean transfer(String merchantsId,String businessId, int amount) throws Exception;
}
