package org.csci4050.bookstore.Bookstore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    /**
     * https://www.baeldung.com/spring-email
     *
     * Also helpful: https://stackoverflow.com/a/34885171
     * @return JavaMailSender
     */
    @Bean
    public JavaMailSender getJavaMailSender() {
        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setProtocol("smtp");
        mailSender.setUsername("bookstorecsci4050@gmail.com");
        mailSender.setPassword("groupNumber6");

        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.quitwait", false);
        properties.put("mail.smtp.ssl.trust", "*");
        properties.put("mail.smtp.socketFactory.port", true);
        properties.put("mail.smtp.debug", true);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", true);
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
