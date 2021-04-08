package zwq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zwq.domain.CommonResult;
import zwq.domain.Order;
import zwq.service.OrderService;

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
