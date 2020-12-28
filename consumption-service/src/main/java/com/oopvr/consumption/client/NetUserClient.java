package com.oopvr.consumption.client;

import com.oopvr.consumption.client.fallback.NetUserClientFallback;
import com.oopvr.consumption.config.FeignConfig;
import com.oopvr.consumption.pojo.InternetUser;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "production-server",fallback = NetUserClientFallback.class,
        configuration = FeignConfig.class)
public interface NetUserClient{

    @GetMapping("/user/{id}")
    InternetUser queryUserId(@PathVariable int id);
}
