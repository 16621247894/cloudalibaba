package com.zwq.controller;

import com.zwq.domain.CommonResult;
import com.zwq.service.OrderService;
import com.zwq.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 添加订单
     * @return
     */
    @PostMapping("/order")
    public CommonResult save(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    /**
     * 修改订单状态
     * @return
     */
    /*@PutMapping("/order")
    public boolean update(){
        Order order=new Order();
        order.setId(1L);
        order.setStatus(0);
        boolean res=orderDao.updateById(order);
        return res;
    }*/



}
