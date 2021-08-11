package com.springboot.springbooterror.app.controller;

import com.springboot.springbooterror.app.errors.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String aritmeticaError(RuntimeException ex, Model model){
        model.addAttribute("error","Error de aritmetica");
        model.addAttribute("message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return "error/generica";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormarException(RuntimeException ex, Model model){
        model.addAttribute("error","Error de formato numero");
        model.addAttribute("message",ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return "error/generica";
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public String userNotFound(UsuarioNotFoundException ex, Model model){
        model.addAttribute("error","Usuario con ID: " .concat(ex.getMessage()).concat(" no existe en el sistema"));
        model.addAttribute("status", HttpStatus.NOT_FOUND.value());
        model.addAttribute("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return "error/generica";
    }
}
