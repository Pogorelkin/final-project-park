package com.epam.webpark.controller;

import com.epam.webpark.entity.User;
import com.epam.webpark.service.UserManager;
import com.epam.webpark.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.epam.webpark.utils.Messages.ERROR;
import static com.epam.webpark.utils.Messages.SUCCESS;

@Controller
public class AuthController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        User user = userManager.getUser();
        User currentUser = user;
        if (user != null) {
            modelAndView.setViewName("redirect:/home-page");
            //if user press on login button without logout, then he'll be redirected to Tree list
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        request.getSession().invalidate();
        return modelAndView;
    }

    @GetMapping("/access_denied")
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/common/error");
        modelAndView.addObject("Access denied.");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginValidation(
            @ModelAttribute(value = "login") String login,
            @ModelAttribute(value = "password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.logPassValidAndReturnUser(login, password);
        if (user != null) {
            userManager.setUser(user);
            modelAndView.setViewName("redirect:/login");
        } else {
            modelAndView.addObject("Typed login and password are invalid");
        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView register(@Validated User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");

        if (result.hasErrors()) {
            modelAndView.addObject(ERROR, result.getAllErrors());
        } else {
            modelAndView.addObject(SUCCESS);
        }
        return modelAndView;
    }
}