package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.dao.OrderDao;
import com.zwq.domain.Order;
import com.zwq.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service

public class OrderImpl extends ServiceImpl<OrderMapper, Order>implements OrderDao {
}
