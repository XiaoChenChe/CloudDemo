package com.example.order.controller;

import com.example.order.properties.OrderProperties;
import com.example.order.service.OrderService;
import com.example.order.bean.Order;
import com.example.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 订单控制层
 * @Version:
 */
@RefreshScope
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/config")
    public String config(){
        return "timeout:"+orderProperties.getOrderTimeout()+"auto-confirm:"+orderProperties.getOrderAutoConfirm();
    }
    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long ProductId,@RequestParam("userId") String userId){
        return orderService.createOrder(ProductId,userId);
    }

    private Product getProductById(Long productId){
        //1，获取到商品服务所在的所有机器的Ip+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //2发送请求
        ServiceInstance instance = instances.get(0);
        String url = instance.getUri()+"/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        return null;
    }

}
