package com.springboot.di.app.controllers;

import com.springboot.di.app.service.MiServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("miServicioMain")
    private MiServiceInterface miService;


    @GetMapping({"/index","/",""})
    public String index(Model model){
        model.addAttribute("objeto", miService.operacion());
        return "index";
    }
}
