package com.example.order.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-15
 * @Description:
 * @Version:
 */
@Component
@ConfigurationProperties(prefix = "order")//配置批量绑定
@Data
public class OrderProperties
{
    String orderTimeout;

    String orderAutoConfirm;
}
