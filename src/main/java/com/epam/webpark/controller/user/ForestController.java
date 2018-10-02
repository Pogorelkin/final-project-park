package com.epam.webpark.controller.user;

import com.epam.webpark.entity.Request;
import com.epam.webpark.entity.Tree;
import com.epam.webpark.service.ForestService;
import com.epam.webpark.service.impl.ForestServiceImpl;
import com.epam.webpark.service.impl.RequestServiceImpl;
import com.epam.webpark.service.impl.UserManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ForestController {

    @Autowired
    ForestService forestService = new ForestServiceImpl();

    @RequestMapping("/forest/")
    public ModelAndView addRequests(HttpServletRequest request)

    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("requests/add");

        List<Tree> forest = forestService.getAll();

        modelAndView.addObject("forest", forest);

        return modelAndView;
    }

}
