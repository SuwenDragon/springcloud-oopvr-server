package com.oopvr.unity.controller;


import com.oopvr.unity.service.TabulationToolNeuron;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@Controller
@RequestMapping("/oopvrUnity")
@Slf4j
public class MakingTablesController {

    @Autowired
    private TabulationToolNeuron tabulationToolNeuron;

    @RequestMapping("/index")
    public String toregister(){

        return "index";
    }


    @PostMapping("/position")
    @ResponseBody
    public String MakingTables(@PathParam("a") String a,
                               @PathParam("b") String b) throws Exception {
        System.out.println("----");
        System.out.println(a+"----------"+b);
        boolean b1 = tabulationToolNeuron.makeTableExcel(a, b);

        return "<h1>"+b1+"</h1>";
    }
}
