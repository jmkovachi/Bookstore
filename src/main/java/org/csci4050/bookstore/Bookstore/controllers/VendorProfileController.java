package org.csci4050.bookstore.Bookstore.controllers;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/vendor")

public class VendorProfileController {

    @Autowired
    private VendorService vendorService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView customerProfile(final Principal principal, final Authentication authentication) throws ValidationException {
        final String username = principal.getName();
        final Vendor vendor = vendorService.getVendor(username).get();
        return new ModelAndView("views/vendor-page", "vendor", vendor);
    }
}
