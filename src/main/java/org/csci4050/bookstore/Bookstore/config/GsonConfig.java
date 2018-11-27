package org.csci4050.bookstore.Bookstore.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GsonConfig {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setDateFormat("MM/yyyy")
                .setDateFormat("MM-yyyy")
                .create();
    }

}
