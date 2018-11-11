package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@SuperBuilder
public class User {
    private String username;
    private String password;
    private String email;
    private String imageUrl;
}
