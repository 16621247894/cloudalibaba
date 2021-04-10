package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.common.util.ResultHolder;
import com.zwq.domain.MerchantsVO;
import com.zwq.mapper.MerchantsMapper;
import com.zwq.service.MerchantsService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Slf4j
public class MerchantsImpl extends ServiceImpl<MerchantsMapper, MerchantsVO> implements MerchantsService {
    @Override
    public boolean merchantsTransfer(BusinessActionContext businessActionContext, Map<String, Object> params) throws Exception {
        log.info("======>招商银行开始校验转入账号.......");
        final String xid = businessActionContext.getXid();
        try {

            System.out.println("获取的xid:" + xid);
            // 交易金额
            int amount = Integer.parseInt(params.get("amount").toString());
            System.out.println("获取的交易金额:" + amount);
            // 账户id
            int merchantsId = Integer.parseInt(params.get("merchantsId").toString());
            //校验转入账号
            MerchantsVO merchantsBankAccount = getById(merchantsId);
            System.out.println("获取的账户未:" + merchantsBankAccount);
            if (merchantsBankAccount == null) {
                log.info(
                        "======>招商银行: 账户[" + merchantsId + "]不存在, txId:" + xid);
                return false;
            }
            // 待转入资金作为 不可用金额划入冻结资金中
            int freezedAmount = merchantsBankAccount.getFreezedAmount() + amount;
            merchantsBankAccount.setFreezedAmount(freezedAmount);
            updateById(merchantsBankAccount);

            //这里模拟招商银行账号加钱操作的时候，抛出异常
            // 模拟异常 ,但是程序走到这里会报错，会走catch部分，catch中如果没有设置 ResultHolder.setResult(getClass(), xid, "p");
            // rollback里面程序会立马返回 这样是防止幂等性
            //int i = 1 / 0;
            log.info("招商银行转账校验结束： account：" + merchantsId + " amount：" + amount + ", dtx transaction id:：" + xid);
            //事务成功，保存一个标识，供第二阶段进行判断
            ResultHolder.setResult(getClass(), xid, "p");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //事务失败的时候也要设置进去，保存一个标识，供第二阶段进行判断
            ResultHolder.setResult(getClass(), xid, "p");
            log.info("MerchantsImpl---->merchantsTransfer业务操作异常回滚！");
            return false;
        }


    }

    /**
     * 确认提交方法
     * @param context 上下文
     * @return
     * @throws Exception
     */
    @Override
    public boolean commitMerchantsTcc(BusinessActionContext context) throws Exception {
        log.info("======>into commitMerchantsTcc.commit() method");
        // 分布式事务ID
        final String xid = context.getXid();
        Map<String, Object> params = (Map<String, Object>) context.getActionContext("params");
        // 账户ID
        int merchantsId = Integer.parseInt(params.get("merchantsId").toString());
        // 转出金额
        int amount = Integer.parseInt(params.get("amount").toString());
        try {
            // 防止幂等性，如果commit阶段重复执行则直接返回
            if (ResultHolder.getResult(getClass(), xid) == null) {
                return true;
            }
            //账户直接加钱
            MerchantsVO merchantsBankAccount = getById(merchantsId);
            // 账户余额增加交易金额
            int newAmount = merchantsBankAccount.getMerchantsAmount() + amount;
            //被冻结的金额清除
            merchantsBankAccount.setFreezedAmount(merchantsBankAccount.getFreezedAmount() - amount);
            merchantsBankAccount.setMerchantsAmount(newAmount);
            updateById(merchantsBankAccount);
            log.info("commit======>招商银行收账成功： account：" + merchantsId + " amount：" + amount + ", dtx transaction id:：" + xid);
            //提交成功是删除标识
            ResultHolder.removeResult(getClass(), xid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("MerchantsImpl---->commit操作异常！");
            //提交成功是删除标识
            ResultHolder.removeResult(getClass(), xid);

            throw new Exception("commit操作异常！");


        }

    }

    /**
     * 取消方法回滚
     * @param context 上下文
     * @return
     * @throws Exception
     */
    @Override
    public boolean rollbackMerchantsTcc(BusinessActionContext context) throws Exception {
        log.info("======>into rollbackMerchantsTcc.rollback() method");

        // 分布式事务ID
        final String xid = context.getXid();
        try {
            System.out.println("获取的map:"+ResultHolder.getMap());

            log.info("获取的xid:" + xid);
            Map<String, Object> params = (Map<String, Object>) context.getActionContext("params");
            // 账户ID
            int merchantsId = Integer.parseInt(params.get("merchantsId").toString());
            // 转出金额
            int amount = Integer.parseInt(params.get("amount").toString());
            // 防止幂等性，如果rollback阶段重复执行则直接返回
            if (ResultHolder.getResult(getClass(), xid) == null) {
                return true;
            }

            MerchantsVO merchantsBankAccount = getById(merchantsId);
            //清除被冻结的金额
            if (merchantsBankAccount == null) {
                // 账户不存在, 无需回滚动作
                return true;
            }
            System.out.println(merchantsBankAccount.getFreezedAmount() + "----" + amount);
            // 冻结金额 清除
            if (merchantsBankAccount.getFreezedAmount() >= amount) {
                merchantsBankAccount.setFreezedAmount(merchantsBankAccount.getFreezedAmount() - amount);
                updateById(merchantsBankAccount);
            }
            log.info(" rollback======>招商银行回滚： account：" + merchantsId + " amount：" + amount + ", dtx transaction id:：" + xid);
            ResultHolder.removeResult(getClass(), xid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("rollback操作异常！");
            ResultHolder.removeResult(getClass(), xid);
            throw new Exception("rollback操作异常！");
        }
    }
}
