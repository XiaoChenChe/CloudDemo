package com.example.order.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description:
 * @Version:
 */

@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long status;
    private String userId;
    private String userName;
    private List<Object> ProductLists;
}
