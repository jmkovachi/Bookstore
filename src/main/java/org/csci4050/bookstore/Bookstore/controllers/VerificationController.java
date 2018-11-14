package org.csci4050.bookstore.Bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VerificationController {

    @RequestMapping(value = "verify/{username}/{email}", method = RequestMethod.GET)
    public ModelAndView verify(@PathVariable final String username, @PathVariable final String email) {
        return null;
    }
}
