package com.springboot.springbooterror.app.errors;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException(String id) {
        super(id);
    }
}
