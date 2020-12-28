package com.oopvr.consumption.controller;

import com.oopvr.consumption.client.NetUserClient;
import com.oopvr.consumption.pojo.InternetUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/netuser")
@Slf4j
public class NetUserController {

    @Autowired
    private NetUserClient netUserClient;


    @GetMapping("/userid/{id}")
    public InternetUser AqueryUser(@PathVariable int id) {
     return netUserClient.queryUserId(id);
    }

//    public String defalutFallback(){
//        return "默认提示：网络拥挤！";
//    }
}
