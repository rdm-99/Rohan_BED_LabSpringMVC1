package com.learning.app.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Model model, Exception ex){
        String msg = ex.getMessage();
        model.addAttribute("error", msg);
        return "error";
    }
}
