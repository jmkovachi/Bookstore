package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.dao.UserDao;
import org.csci4050.bookstore.Bookstore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ExampleController {
	
	@Autowired
	private UserDao userDao;

	@RequestMapping("yo")
	public ModelAndView yo() throws Exception {
		final Client client = Client.builder()
				.name("name")
				.address("address")
				.company("company")
				.build();
		client.setUsername("username");
		client.setPassword("password");
		client.setImageUrl("url");
		client.setRole("ROLE_CLIENT");

		return new ModelAndView("views/helloworld", "yo", null);
	}

}
