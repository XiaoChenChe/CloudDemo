package com.example.product.controller;

import com.example.product.Service.ProductService;
import com.example.product.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 商品控制层
 * @Version:
 */
@Controller
@RestController
public class ProductController {

    //查询商品
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId){

        Product product = productService.getProductById(productId);

        return product;
    }
}
