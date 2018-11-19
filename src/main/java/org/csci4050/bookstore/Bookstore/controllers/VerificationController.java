package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    @RequestMapping(value = "verify/{username}", method = RequestMethod.GET)
    public ModelAndView verify(@PathVariable final String username) throws ValidationException {
        verificationService.sendVerificationEmail(username);
        // Populating ModelAndView to be implemented.
        return new ModelAndView("views/verification", "verify", null);
    }

    @RequestMapping(value = "verify/{username}/{code}", method = RequestMethod.POST)
    public ResponseEntity verify(@PathVariable final String username, @PathVariable final String code) throws ValidationException {
        final int parsedCode = Integer.parseInt(code);
        if (verificationService.verifyCustomer(username, parsedCode)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
