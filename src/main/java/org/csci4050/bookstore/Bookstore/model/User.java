package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private String username;
    private String password;
    private String email;
    private String address;
    private Date birthDate;
}
