package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.dao.ClientDao;
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

	@Autowired
	private ClientDao clientDao;

	@RequestMapping("yo")
	public ModelAndView yo() throws Exception {
		final Client client = Client.builder()
				.name("name")
				.address("address")
				.company("company")
				.build();
		client.setUsername("u");
		client.setPassword("password1");
		client.setImageUrl("url");
		client.setEmail("yahoo.com");
		client.setRole("ROLE_CLIENT");
		clientDao.createClient(client);
		System.out.println(userDao.getUser("u"));
		System.out.println(clientDao.getClient("u"));
		client.setAddress("newAddress");
		client.setName("John");
		clientDao.updateClient(client);
		System.out.println(clientDao.getClient("u"));
		return new ModelAndView("views/helloworld", "yo", null);
	}

}
