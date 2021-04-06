package com.zwq.controller;

import com.zwq.dao.OrderDao;
import com.zwq.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/order")
public class OrderController {

    @Autowired
    private OrderDao  orderDao;

    @PostMapping
    public boolean save(){
        Order order=new Order(null,1L,1L,1,new BigDecimal(25),1);
        boolean res=orderDao.save(order);
        System.out.println("获取的res:"+res);
        return res;
    }
}
