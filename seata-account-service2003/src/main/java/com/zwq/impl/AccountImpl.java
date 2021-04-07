package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.domain.Account;
import com.zwq.mapper.AccountMapper;
import com.zwq.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
public class AccountImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        //模拟超时异常，全局事务回滚   如果有全局事务的话 当这边出错了 应该全部回滚，而不是目前的 添加订单成功 并且库存扣减成功
        try {
            TimeUnit.SECONDS.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
        accountMapper.decrease(userId,money);
    }
}
