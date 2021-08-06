package com.springboot.app.springbootwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping({"/", ""})
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(required = false, defaultValue = "default value") String texto, Model model) {
        model.addAttribute("resultado", "El parametro enviado es = " + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(
            @RequestParam(required = false, defaultValue = "default value") String saludo,
            @RequestParam(required = false) Integer numero, Model model) {
        model.addAttribute("resultado", "El saludo enviado es = " + saludo + " y el numero es " + numero);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }

        model.addAttribute("resultado", "El saludo enviado es = " + saludo + " y el numero es " + numero);
        return "params/ver";
    }
}
