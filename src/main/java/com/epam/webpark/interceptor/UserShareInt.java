package com.epam.webpark.interceptor;


import com.epam.webpark.entity.User;
import com.epam.webpark.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserShareInt implements HandlerInterceptor {

    @Autowired
    private UserManager userManager;




    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        User currentUser = userManager.getUser();
        if (modelAndView != null) {
            modelAndView.addObject("current_user", currentUser);
        }
    }
}