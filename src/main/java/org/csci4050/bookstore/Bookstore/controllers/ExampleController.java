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
	public ModelAndView yo() {
		System.out.println(userDao.getUser("admin").toString());
		return new ModelAndView("views/helloworld", "yo", null);
	}

}
