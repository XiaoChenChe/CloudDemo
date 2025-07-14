package com.example.order.service;

import com.example.order.bean.Order;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 订单服务
 * @Version:
 */


public interface OrderService {
    Order createOrder(Long ProductId,String userId);
}
