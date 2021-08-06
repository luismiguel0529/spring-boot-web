package com.springboot.di.app.controllers;

import com.springboot.di.app.service.MiService;
import com.springboot.di.app.service.MiServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private MiServiceInterface miService;

    public IndexController(MiServiceInterface miService) {
        this.miService = miService;
    }

    @GetMapping({"/index","/",""})
    public String index(Model model){
        model.addAttribute("objeto", miService.operacion());
        return "index";
    }
}
