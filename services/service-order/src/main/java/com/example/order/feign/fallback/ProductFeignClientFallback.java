package com.example.order.feign.fallback;

import com.example.order.feign.ProductFeign;
import com.example.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-18
 * @Description:
 * @Version:
 */

@Component
public class ProductFeignClientFallback implements ProductFeign {
    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调....");
        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal(10));
        product.setProductName("未知商品");
        return product;
    }
}
