package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.VerificationException;
import org.csci4050.bookstore.Bookstore.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    @RequestMapping(value = "verify/{username}/{email}", method = RequestMethod.GET)
    public ModelAndView verify(@PathVariable final String username, @PathVariable final String email) throws VerificationException {
        verificationService.sendVerificationEmail(username, email);
        // Populating ModelAndView to be implemented.
        return null;
    }
}
