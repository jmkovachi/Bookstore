package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Builder
@SuperBuilder
@Data
public class Customer extends User {
    private String firstName;
    private String minit;
    private String lastName;
    private String address;
    private Date birthDate;
    private boolean verified;
    private boolean newsletter;
}
