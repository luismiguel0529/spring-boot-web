package com.springboot.springbooterror.app.controller;

import com.springboot.springbooterror.app.errors.UsuarioNotFoundException;
import com.springboot.springbooterror.app.model.Usuario;
import com.springboot.springbooterror.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ApiController {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/index")
    public String index(){
        //Integer valor = 100/0;
        Integer valor = Integer.parseInt("s");
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model){
        Usuario usuario = service.findByIdOptional(id).orElseThrow(() -> new UsuarioNotFoundException(id.toString()));
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo","Detalle usuario: ".concat(usuario.getNombre()));
        return "ver";
    }
}
