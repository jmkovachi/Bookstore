package org.csci4050.bookstore.Bookstore.ui.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.Statement;

@Controller
@RequestMapping("/")
public class ExampleController {

	@Autowired
	private Connection connection;

	@RequestMapping("hi")
	/**
	 * Example controller connecting to the database and creating a new table. A modelandview object is returned.
	 */
	public ModelAndView hello() throws Exception {
		Statement stmt = connection.createStatement();

		String sql = "CREATE TABLE REGISTRATION " +
				"(id INTEGER not NULL, " +
				" first VARCHAR(255), " +
				" last VARCHAR(255), " +
				" age INTEGER, " +
				" PRIMARY KEY ( id ))";

		try {
			stmt.executeUpdate(sql);
			System.out.println("Executed statement");
			connection.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		System.out.println("Created table in given database...");
		return new ModelAndView("views/helloworld", "message", null);
	}

}
