package org.csci4050.bookstore.Bookstore.controllers;

import lombok.Builder;
import lombok.Data;
import org.csci4050.bookstore.Bookstore.model.Book;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.csci4050.bookstore.Bookstore.service.BookService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class VendorMenuController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/vendor/dashboard", method = RequestMethod.GET)
    public ModelAndView vendorPage(final Principal principal) {
        final String username = principal.getName();
        final Vendor vendor = vendorService.getVendor(username).get();
        final List<Book> vendorBooks = bookService.getBooksByColumns("v_username", username);
        final VendorPage vendorPage = VendorPage.builder()
                .vendor(vendor)
                .books(vendorBooks)
                .build();
        return new ModelAndView("views/vendor-menu", "vendor", vendorPage);
    }

    @Data
    @Builder
    public static class VendorPage {
        private List<Book> books;
        private Vendor vendor;
    }

}
