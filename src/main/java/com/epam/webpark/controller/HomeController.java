package com.epam.webpark.controller;

import com.epam.webpark.service.ForestService;
import com.epam.webpark.service.UserManager;
import com.epam.webpark.service.impl.ForestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private UserManager userManager;

    @RequestMapping("/home")
    public ModelAndView hello(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:home-page");
        userManager.getUser();

        modelAndView.addObject("Hello, ", userManager.getUser().getFirstName());
        ForestService forestService = new ForestServiceImpl();

        modelAndView.addObject(forestService.getAll());
        modelAndView.addObject("Here's list of every tree in our park.");


        return modelAndView;
    }

}
