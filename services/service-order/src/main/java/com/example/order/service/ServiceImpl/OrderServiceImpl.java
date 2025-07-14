package com.example.order.service.ServiceImpl;

import com.example.order.service.OrderService;
import com.example.order.bean.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 订单服务实现层
 * @Version:
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Long ProductId, String userId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setProductLists(null);
        order.setStatus(1L);
        order.setTotalAmount(new BigDecimal(100));
        order.setUserName("测试用户");
        return order ;
    }
}
