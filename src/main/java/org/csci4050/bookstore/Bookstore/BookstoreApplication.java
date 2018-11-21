package org.csci4050.bookstore.Bookstore;

import org.csci4050.bookstore.Bookstore.scripts.InsertBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("org.csci4050.bookstore.Bookstore")
public class BookstoreApplication extends SpringBootServletInitializer implements ApplicationRunner {

	@Bean
	public ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}

	@Autowired
	private InsertBooks insertBooks;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookstoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    /**
     * Use command line args to configure options.
     * Ex: spring-boot:run -Dfork=false -Dspring-boot.run.arguments=--script=true
     * @param args Application arguments passed in from maven goals execution
     * @throws Exception general exception
     */
	@Override
	public void run(final ApplicationArguments args) throws Exception {
		final List<String> argValuesList = args.getOptionValues("script");
		if (!argValuesList.isEmpty() && argValuesList.get(0).equals("true")) {
			insertBooks.insertBooks();
		}
	}

}
