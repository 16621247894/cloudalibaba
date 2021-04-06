package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.service.AccountService;
import com.zwq.service.OrderService;
import com.zwq.service.StorageService;
import com.zwq.domain.Order;
import com.zwq.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderImpl extends ServiceImpl<OrderMapper, Order>implements OrderService {

/*
    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;*/
    @Override
    public void create(Order order) {
        log.info("--------->开始新建订单");
        //添加订单方法
        this.save(order);


        log.info("-------->订单微服务开始调用库存，做扣减count");
        //storageService.decrease(order.getProductId(),order.getCount());
        log.info("-------->订单微服务开始调用库存，做扣减count  end.......");



        log.info("-------->订单微服务开始调用账户，做扣减Money");
        //accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------->订单微服务开始调用账户，做扣减Money   end ..............");

        //修改订单状态0 ----1
        log.info("修改订单"+order.getId()+"状态");
        order.setStatus(1);
        this.updateById(order);


    }
}
