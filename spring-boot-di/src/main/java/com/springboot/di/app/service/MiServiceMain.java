package com.springboot.di.app.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioMain")
//@Primary
public class MiServiceMain implements MiServiceInterface {

    @Override
    public String operacion() {
        return "Ejecutando algún proceso importante complejo MAIN";
    }
}
