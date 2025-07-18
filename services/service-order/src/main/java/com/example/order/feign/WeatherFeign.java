package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather-service",url = "http://aliv18.data.moji.com")
public interface WeatherFeign {

    @PostMapping("whapi/json/alicityweather/condition")
    String getWeather(@RequestHeader String auth,
                      @RequestParam String token,
                      @RequestParam String cityId);
}
