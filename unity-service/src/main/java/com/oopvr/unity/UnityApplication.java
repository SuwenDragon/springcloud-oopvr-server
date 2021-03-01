package com.oopvr.unity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UnityApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnityApplication.class, args);
    }
}
