package com.springboot.springbooterror.app.service;

import com.springboot.springbooterror.app.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> listar();
    public Usuario findById(Integer id);
    public Optional<Usuario> findByIdOptional(Integer id);
}
