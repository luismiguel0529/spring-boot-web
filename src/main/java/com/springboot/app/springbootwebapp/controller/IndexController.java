package com.springboot.app.springbootwebapp.controller;

import com.springboot.app.springbootwebapp.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping(value = {"/home", "/index"})
    public String index(ModelMap model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(ModelMap model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Miguel");
        usuario.setApellido("Rodriguez");
        usuario.setEmail("l.miguel0529@hotmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(" ") + usuario.getNombre().concat(" ").concat(usuario.getApellido()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    //disponible para todos los metodos o todo el controllador
    @ModelAttribute("usuarios")
    public List<Usuario> usuarioList() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario().setNombre("Miguel").setApellido("Rodriguez").setEmail("miguel@mail.com"));
        usuarios.add(new Usuario().setNombre("Luis").setApellido("Herrera").setEmail("luis@mail.com"));
        return usuarios;
    }
}
