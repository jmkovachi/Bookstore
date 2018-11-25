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
		client.setUsername("i");
		client.setPassword("password2");
		client.setImageUrl("url1");
		client.setEmail("yahoo2.com");
		client.setRole("ROLE_CLIENT");
		clientDao.createClient(client);
		System.out.println(userDao.getUser("i"));
		System.out.println(clientDao.getClient( "i"));
		client.setAddress("newAddress");
		client.setName("John");
		clientDao.updateClient(client);
		System.out.println(clientDao.getClient("i"));
		return new ModelAndView("views/helloworld", "client", client);
	}

	@RequestMapping("ex")
	public ModelAndView mv() throws Exception {
		return new ModelAndView("views/cart", "yo", null);
	}

}
