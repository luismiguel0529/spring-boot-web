package com.springboot.di.app.service;

import org.springframework.stereotype.Service;

@Service("miServicio")
public class MiService implements MiServiceInterface {

    @Override
    public String operacion() {
        return "Ejecutando algún proceso importante";
    }
}
