package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public ModelAndView clientPage() {
        return new ModelAndView("views/client-page", "client", null);
    }

}
