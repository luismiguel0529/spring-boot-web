package com.springboot.di.app.service;

import org.springframework.stereotype.Service;

//@Service("miServicioSecundary")
public class MiServiceSecundary implements MiServiceInterface {

    @Override
    public String operacion() {
        return "Ejecutando algún proceso importante SECUNDARY";
    }
}
