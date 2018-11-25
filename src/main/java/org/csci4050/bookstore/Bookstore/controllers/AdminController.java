package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private VerificationService verificationService;

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public ModelAndView admin() throws ValidationException {
        // send verification email and return the address mailed to
        //final String mailedAddress = verificationService.sendVerificationEmail(username);

        return new ModelAndView("views/admin-page", "admin-page", null);
    }
}
