package com.example.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-15
 * @Description:
 * @Version:
 */

@Configuration
public class ProductServiceConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
