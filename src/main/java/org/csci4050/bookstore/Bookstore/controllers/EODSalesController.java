package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EODSalesController {

    @RequestMapping(value = "/end-of-day-sales", method = RequestMethod.GET)
    public ModelAndView daySales() {
        return new ModelAndView("views/end-of-day-sales", "eodsales", null);
    }


}