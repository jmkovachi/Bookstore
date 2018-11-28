package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class VendorMenuController {

    @Autowired
    private VendorService vendorService;

    @RequestMapping(value = "/vendor/dashboard", method = RequestMethod.GET)
    public ModelAndView vendorPage(final Principal principal) {
        final String username = "atombooks";
        final Vendor vendor = vendorService.getVendor(username).get();
        return new ModelAndView("views/vendor-menu", "vendor", vendor);
    }

}
