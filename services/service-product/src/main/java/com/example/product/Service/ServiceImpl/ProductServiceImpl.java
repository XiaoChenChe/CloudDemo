package com.example.product.Service.ServiceImpl;

import com.example.product.Service.ProductService;
import com.example.product.bean.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 商品实现类
 * @Version:
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();

        product.setId(productId);
        product.setPrice(new BigDecimal("100"));
        product.setProductName("测试商品"+productId);
        product.setNum(10);

        return product;
    }
}
