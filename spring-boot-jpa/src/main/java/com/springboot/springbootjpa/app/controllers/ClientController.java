package com.springboot.springbootjpa.app.controllers;

import com.springboot.springbootjpa.app.models.Client;
import com.springboot.springbootjpa.app.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("client")
public class ClientController {

    @Autowired
    private IClientService iClientService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", "List of Clients");
        model.addAttribute("clients", iClientService.findAll());
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
    public String save(@Valid Client client, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()){
            model.addAttribute("title","Form of Clients");
            return "form";
        }

        String messageFlash = client.getId() != null ? "Client edited." : "Client created.";
        iClientService.save(client);
        status.setComplete();
        flash.addFlashAttribute("success", messageFlash);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model, RedirectAttributes flash){
        Client client = null;
        if (id > 0){
            client = iClientService.findById(id);
            if (client == null){
                flash.addFlashAttribute("error","Id Client not exist in BD.");
                return "redirect:/list";
            }
        } else {
            flash.addFlashAttribute("error","Id client can't be zero.");
            return "redirect:/list";
        }
        model.put("client",client);
        model.put("title","Edit Client");
        flash.addFlashAttribute("success","Client edited.");
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes flash){
        iClientService.delete(id);
        flash.addFlashAttribute("success","Client deleted.");
        return "redirect:/list";
    }
}
