package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController {

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView catalog() {
        return new ModelAndView("views/catalog", "catalog", null);
    }
}
