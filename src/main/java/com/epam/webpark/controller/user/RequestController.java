package com.epam.webpark.controller.user;

import com.epam.webpark.entity.Request;
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
public class RequestController {

    @Autowired
    private UserManagerImpl userManager;

    @Autowired
    private RequestServiceImpl requestService;

    @RequestMapping("/requests/")
    public ModelAndView addRequests(HttpServletRequest request)

    {
        ModelAndView modelAndView = new ModelAndView();

        List<Request> requests = requestService.getAll();

        modelAndView.addObject("requests", requests);

        return modelAndView;
    }

    @PostMapping("/requests/add")
    public ModelAndView makeRequest(@ModelAttribute(value = "id") long id,
                                    @ModelAttribute(value = "workKind") String workKind,
                                    @ModelAttribute(value = "status") String status,
                                    @ModelAttribute(value = "id_owner") long id_owner,
                                    @ModelAttribute(value = "id_forester") long id_forester,
                                    @ModelAttribute(value = "id_tree") long id_tree

    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/requests/");
        this.requestService.add(new Request(workKind, status, id_owner, id_forester, id_tree));
        return modelAndView;
    }

    @PostMapping("requests/confirm")
    public ModelAndView workComplete(@ModelAttribute(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/requests");
        requestService.confirmRequest(id);

        return modelAndView;
    }

    @PostMapping("requests/done")
    public ModelAndView confirmWork(@ModelAttribute(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/requests");
        requestService.workComplete(id);
        return modelAndView;
    }


}
