package org.csci4050.bookstore.Bookstore.controllers;

import org.csci4050.bookstore.Bookstore.dao.UserDao;
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
		userDao.createUser("user", "abcd", "gmail.com", "ROLE_ADMIN", "url");
		System.out.println(userDao.getUser("user").toString());
		userDao.updateUser("a", "abcde", "yahoo.com");
		System.out.println(userDao.getUser("a").toString());
		return new ModelAndView("views/helloworld", "yo", null);
	}

}
