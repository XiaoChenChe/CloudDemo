package com.example.order.service.ServiceImpl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.order.feign.ProductFeign;
import com.example.order.service.OrderService;
import com.example.order.bean.Order;
import com.example.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 订单服务实现层
 * @Version:
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductFeign productFeign;

    @SentinelResource(value = "createOrder")
    @Override
    public Order createOrder(Long ProductId, String userId) {
        Product product = productFeign.getProductById(ProductId);
        //Product product = getProductFromRemoteWithBalanceLoadWithAnnotation(ProductId);
        Order order = new Order();
        order.setId(1L);
        //总金额

        order.setUserId(userId);
        order.setProductLists(null);
        order.setStatus(1L);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserName("测试用户");

        order.setProductLists(Arrays.asList(product));
        return order ;
    }

    private Product getProductFromRemote(Long productId){
        //1，获取到商品服务所在的所有机器的Ip+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //2发送请求
        ServiceInstance instance = instances.get(0);
        String url = instance.getUri()+"/product/"+productId;
        log.info("请求的url为:{}",url);
        Product result = restTemplate.getForObject(url,Product.class);
        return result;
    }
    private Product getProductFromRemoteWithBalanceLoad(Long productId){
        ServiceInstance instance = loadBalancerClient.choose("service-product");

        String url = instance.getUri()+"/product/"+productId;
        log.info("请求的url为:{}",url);
        Product result = restTemplate.getForObject(url,Product.class);
        return result;
    }

    private Product getProductFromRemoteWithBalanceLoadWithAnnotation(Long productId){
        String url = "http://service-product/product/"+productId;
        log.info("请求的url为:{}",url);
        Product result = restTemplate.getForObject(url,Product.class);
        return result;
    }


}
