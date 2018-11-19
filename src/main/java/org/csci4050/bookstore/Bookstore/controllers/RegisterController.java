package org.csci4050.bookstore.Bookstore.controllers;

import com.google.gson.Gson;
import org.csci4050.bookstore.Bookstore.exceptions.ValidationException;
import org.csci4050.bookstore.Bookstore.model.Client;
import org.csci4050.bookstore.Bookstore.model.Customer;
import org.csci4050.bookstore.Bookstore.model.Vendor;
import org.csci4050.bookstore.Bookstore.service.ClientService;
import org.csci4050.bookstore.Bookstore.service.CustomerService;
import org.csci4050.bookstore.Bookstore.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private Gson gson;

    /**
     * Controller that registers a customer. Tested that it works.
     *
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
     * @param jsonCustomer customer we are inserting
     * @return json response mapping from created customer (should be the same json string we posted)
     * @throws Exception when an insert using JDBC fails
     */
    @RequestMapping(value = "customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerCustomer(@RequestBody final String jsonCustomer) throws Exception {
        final Customer customer = gson.fromJson(jsonCustomer, Customer.class);
        return gson.toJson(customerService.registerCustomer(customer));
    }

    @RequestMapping(value = "customer", method = RequestMethod.GET)
    public ModelAndView registerCustomerPage() throws ValidationException {
        return new ModelAndView("views/register", "register", null);
    }


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
    @RequestMapping(value = "vendor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerVendor(@RequestBody final String jsonVendor) throws Exception {
        final Vendor vendor = gson.fromJson(jsonVendor, Vendor.class);
        return gson.toJson(vendorService.registerVendor(vendor));
    }

    /**
     * Controller that registers a client. Tested that it works.
     *
     * Example JSON body:
     * {
     * 	"name" : "John Smith",
     * 	"company" : "Scholastic",
     * 	"address" : "480 Menlo pk dr",
     * 	"username" : "clientUser",
     *  "password" : "clientPass",
     *  "email" : "gmail.com",
     *  "role" : "ROLE_CLIENT",
     *  "imageUrl" : "url"
     * }
     * @param jsonClient json string we are consuming
     * @return json response mapping from created client (should be the same json string we posted)
     * @throws Exception JDBC insert fails
     */
    @RequestMapping(value = "client", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String registerClient(@RequestBody final String jsonClient) throws Exception {
        final Client client = gson.fromJson(jsonClient, Client.class);
        return gson.toJson(clientService.registerClient(client));
    }
}
