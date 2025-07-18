package com.example.order.feign;

import com.example.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-17
 * @Description:
 * @Version:
 */

@FeignClient("service-product")
public interface ProductFeign {

    @GetMapping("product/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
