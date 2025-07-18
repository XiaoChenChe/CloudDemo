package com.example.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-18
 * @Description:
 * @Version:
 */

@Component
public class XTokenRequestInterceptor implements RequestInterceptor {

    /**
     * 请求拦截器，
     * @param requestTemplate，放了请求的详细信息
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
