package org.csci4050.bookstore.Bookstore.controllers;

import com.google.gson.Gson;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private Gson gson;

    @RequestMapping(value = "customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    /**
     * Example JSON body for posting to registerCustomer
     * {
     * 	"firstName" : "John",
     * 	"minit" : "M",
     * 	"lastName" : "Kovachi",
     * 	"address" : "3735 Tulip Tree Rd",
     * 	"birthDate" : "09-18-1996",
     * 	"verified" : "false",
     * 	"newsletter" : "true",
     * 	"username" : "jm",
     * 	"password" : "newPass",
     * 	"email" : "gmail.com",
     * 	"role" : "ROLE_CUSTOMER",
     * 	"imageUrl" : "url"
     * }
     */
    public String registerCustomer(@RequestBody final String jsonCustomer) throws Exception {
        final Customer customer = gson.fromJson(jsonCustomer, Customer.class);
        customerService.registerCustomer(customer);
        return gson.toJson(customer);
    }

    @RequestMapping(value = "vendor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    /**
     * Example json body:
     * {
     * 	"company" : "Scholastic",
     * 	"address" : "480 Menlo pk dr",
     * 	"username" : "vendorUser",
     *  "password" : "vendorPass",
     *  "email" : "gmail.com",
     *  "role" : "ROLE_VENDOR",
     *  "imageUrl" : "url"
     * }
     */
    public String registerVendor(@RequestBody final String jsonVendor) throws Exception {
        final Vendor vendor = gson.fromJson(jsonVendor, Vendor.class);
        vendorService.registerVendor(vendor);
        return gson.toJson(vendor);
    }
}
