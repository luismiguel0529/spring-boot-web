package com.springboothorario.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @Value("${config.horario.apertura}")
    private Integer apertura;
    @Value("${config.horario.cierre}")
    private Integer cierre;

    @GetMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("titulo","Bienvenido al horario de atención a cliente");
        return "index";
    }

    @GetMapping("/cerrado")
    public String cerrado(Model model){
        StringBuilder stringBuilder = new StringBuilder("Cerrado por favor visitanos desde las ");
        stringBuilder.append(apertura);
        stringBuilder.append(" y las ");
        stringBuilder.append(cierre);
        stringBuilder.append("hrs. Gracias");

        model.addAttribute("titulo","Fuera del horario de atención");
        model.addAttribute("mensaje",stringBuilder.toString());
        return "cerrado";
    }
}
