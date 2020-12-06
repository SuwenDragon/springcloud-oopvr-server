package com.oopvr.production.controller;



import com.oopvr.production.pojo.InternetUser;
import com.oopvr.production.service.InternetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class InterNetUserController {

    @Autowired
    private InternetUserService internetUserService;


    @GetMapping("/{id}")
    public InternetUser queryUser(@PathVariable int id){
        System.out.println(id);
        System.out.println(internetUserService.queryUser(id).toString());
        return internetUserService.queryUser(id);
    }

    @GetMapping("/kkk/")
    public InternetUser AqueryUser(@RequestParam("name") int id){
        System.out.println(id);
        System.out.println(internetUserService.AqueryUser(id).toString());
        return internetUserService.AqueryUser(id);
    }
}
