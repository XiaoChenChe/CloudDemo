package com.example.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * @Author: cjx
 * @CreateTime: 2025-07-14
 * @Description: 订单启动类
 * @Version:
 */
//配置中心中的配置优先级比配置文件优先级高，先导入优先，
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OrderMainApplication {

    public static void main(String[] args){
        SpringApplication.run(OrderMainApplication.class,args);
    }

    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
        return args->{
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener("service-order.yaml", "DEFAULT_GROUP", new Listener(){
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(4);
                }
                @Override
                public void receiveConfigInfo(String configInfo){
                    System.out.println("接收到配置更新"+configInfo);
                }
            });
            System.out.println("服务启动完成");
        };
    }
}