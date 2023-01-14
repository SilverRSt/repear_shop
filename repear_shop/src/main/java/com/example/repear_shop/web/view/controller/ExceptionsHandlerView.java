package com.example.repear_shop.web.view.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandlerView {

    @ExceptionHandler(Exception.class)
    protected String handleException(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "/errors/error.html";
    }
}
