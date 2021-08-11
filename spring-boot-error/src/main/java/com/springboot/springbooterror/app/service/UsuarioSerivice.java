package com.springboot.springbooterror.app.service;

import com.springboot.springbooterror.app.errors.UsuarioNotFoundException;
import com.springboot.springbooterror.app.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSerivice implements IUsuarioService{

    private List<Usuario> list;

    public UsuarioSerivice() {
        this.list = new ArrayList<>();
        this.list.add(new Usuario(1,"Miguel","Rodriguez"));
        this.list.add(new Usuario(2,"Luis","Herrera"));
        this.list.add(new Usuario(3,"Paulina","Hincapie"));
    }

    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario findById(Integer id) {
        return list.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UsuarioNotFoundException(id.toString()));
    }

    @Override
    public Optional<Usuario> findByIdOptional(Integer id) {
        return list.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

    }
}
