package com.springboot.springbootjpa.app.controllers;

import com.springboot.springbootjpa.app.models.Client;
import com.springboot.springbootjpa.app.service.IClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private IClientDao iClientDao;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", "List of Clients");
        model.addAttribute("clients", iClientDao.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String save(Map<String, Object> model){
        Client client = new Client();
        model.put("client",client);
        model.put("title","Form of Clients");
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid Client client, BindingResult result){
        if (result.hasErrors()){
            return  "form";
        }
        iClientDao.save(client);
        return "redirect:list";
    }
}
