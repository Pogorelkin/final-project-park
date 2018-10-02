package com.epam.webpark.controller;

import com.epam.webpark.exception.UserExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import static com.epam.webpark.utils.Messages.ERROR;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserExistException.class)
    public ModelAndView handleException(UserExistException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/common/error");
        modelAndView.addObject(ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/common/error");
        modelAndView.addObject(ERROR, " reason: " + ex.getMessage());
        return modelAndView;
    }
}