package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LowInvNoticeController {

    @RequestMapping(value = "/low-inv-notice", method = RequestMethod.GET)
    public ModelAndView lowinv() {
        return new ModelAndView("views/low-inv-notice", "lowinv", null);
    }


}