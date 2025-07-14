package com.example.product.Service;

import com.example.product.bean.Product;


/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 商品控制层
 * @Version:
 */

public interface ProductService {
    Product getProductById(Long productId);
}
