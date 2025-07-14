package com.example.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 商品实体类
 * @Version:
 */

@Data
public class Product {
    private long id;
    private BigDecimal price;
    private String productName;
    private int num;

}
