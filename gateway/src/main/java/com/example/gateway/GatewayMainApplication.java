package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-28
 * @Description:
 * @Version:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMainApplication {
    public static void main(String[] args){
        SpringApplication.run(GatewayMainApplication.class,args);
    }
}
