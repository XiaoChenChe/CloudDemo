package com.com.example.order;

import com.example.order.feign.WeatherFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-18
 * @Description:
 * @Version:
 */

@SpringBootTest
public class WeatherTest {

    @Autowired
    WeatherFeign weatherFeign;

    @Test
    void test1(){
        String weather =weatherFeign.getWeather("sfsdakfsadl","12321","sdfsd");
        System.out.println("weather = " + weather);
    }

}
