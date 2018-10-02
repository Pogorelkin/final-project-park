package com.epam.webpark.controller.user;

import com.epam.webpark.entity.Tree;
import com.epam.webpark.service.ForestService;
import com.epam.webpark.service.impl.ForestServiceImpl;

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

    {   ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("forest/");

        List<Tree> forest = forestService.getAll();

        modelAndView.addObject("forest", forest);

        return modelAndView;
    }

    @PostMapping("/forest/add")
    public ModelAndView addTree(@ModelAttribute(value = "id") String treeKind,
                                @ModelAttribute(value = "id") String color
                                ){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("requests/add");

        forestService.add(new Tree(treeKind, color, 1));

        return modelAndView;

    }

    @PostMapping("/forest/cut")
    public ModelAndView cutTree(@ModelAttribute(value = "id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("requests/cut");

        forestService.deleteById(id);

        return modelAndView;
    }

    @PostMapping("/forest/paint")
    public ModelAndView paintTree(@ModelAttribute(value = "id") long id,
                                  @ModelAttribute(value = "color") String color){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("requests/paint");

        forestService.paintTree(id, color);
        return  modelAndView;
    }


}
