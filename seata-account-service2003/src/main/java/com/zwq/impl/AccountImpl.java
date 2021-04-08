package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.domain.Account;
import com.zwq.mapper.AccountMapper;
import com.zwq.service.AccountService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class AccountImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AccountMapper accountMapper;

    //@Override
    public boolean commitTcc(BusinessActionContext context) {
        log.info("xid = " + context.getXid() + "扣减账户余额-提交成功");
        return true;
    }

    //@Override
    public boolean cancel(BusinessActionContext context) {
        log.info("xid = " + context.getXid() + "回滚操作");
        log.info("please manually rollback this data-userId:" + context.getActionContext("userId"));
        log.info("please manually rollback this data-money:" + context.getActionContext("money"));
        return true;
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        //模拟超时异常，全局事务回滚   如果有全局事务的话 当这边出错了 应该全部回滚，而不是目前的 添加订单成功 并且库存扣减成功
        /*try {
            TimeUnit.SECONDS.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }*/

        accountMapper.decrease(userId,money);
        logger.info("xxxx 账户扣减");
    }
}
