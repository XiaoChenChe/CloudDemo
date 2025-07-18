package com.example.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description:
 * @Version:
 */

@Configuration
public class OrderConfig {


    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }
    @Bean
    Logger.Level feginLoggerLevel(){
        return Logger.Level.FULL;
    }
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
