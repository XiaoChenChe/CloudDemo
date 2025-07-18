package com.example.order.feign.fallback;

import com.example.order.feign.ProductFeign;
import com.example.product.bean.Product;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-18
 * @Description:
 * @Version:
 */


public class ProductFeignClientFallback implements ProductFeign {
    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调....");
        return null;
    }
}
