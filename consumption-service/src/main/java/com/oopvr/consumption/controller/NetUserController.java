package com.oopvr.consumption.controller;

import com.oopvr.consumption.client.NetUserClient;
import com.oopvr.consumption.pojo.InternetUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/netuser")
@Slf4j
public class NetUserController {

    @Autowired
    private NetUserClient netUserClient;


    @PostMapping("/userid/")
//    @GetMapping()
    public InternetUser AqueryUser(@PathParam("id") int id) {
     return netUserClient.queryUserId(id);
    }

//    public String defalutFallback(){
//        return "默认提示：网络拥挤！";
//    }
}
