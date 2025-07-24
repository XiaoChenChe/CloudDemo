package com.example.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc_v6x.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.common.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-21
 * @Description:
 * @Version:
 */

@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, String resourceName, BlockException e) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        //获得响应数据
        PrintWriter writer = response.getWriter();



        R.error(resourceName+"被Sentinel限制了，原因是"+e.getMessage(),500);

        String json = objectMapper.writeValueAsString(R.error(resourceName+"被Sentinel限制了，原因是"+e.getMessage(),500));
        writer.write(json);
        writer.flush();
        writer.close();
        //关联规则，例如读和写操作，两个操作是相关的，可以限制操作
    }
}
