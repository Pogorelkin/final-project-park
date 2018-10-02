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





import static com.epam.webpark.utils.Messages.ERROR;
import static com.epam.webpark.utils.Messages.SUCCESS;

@Controller
public class RequestController {

    @Autowired
    private UserManagerImpl userManager;//UserManager userManager;

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
    public ModelAndView makeRequest() {
        ModelAndView modelAndView = new ModelAndView();
        List<Request> requests = this.requestService.getAll();
        modelAndView.addObject("requests", requests);

        modelAndView.setViewName("redirect:/requests/add");


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
