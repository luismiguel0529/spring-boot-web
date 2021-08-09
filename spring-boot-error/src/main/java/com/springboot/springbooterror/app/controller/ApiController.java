package com.springboot.springbooterror.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

    @GetMapping("/index")
    public String index(){
        //Integer valor = 100/0;
        Integer valor = Integer.parseInt("s");
        return "index";
    }
}
