package zwq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import zwq.domain.Order;

@Service
public interface OrderService extends IService<Order> {
    // 需要2个方法 添加订单  修改订单状态方法


    //下单方法
    void create(Order order);




}
