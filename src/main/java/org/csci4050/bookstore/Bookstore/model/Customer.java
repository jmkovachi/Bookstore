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

    public static final String firstNameCol = "first_name";
    public static final String minitCol = "minit";
    public static final String lastNameCol = "last_name";
    public static final String addressCol = "address";
    public static final String birthDateCol = "birth_date";
    public static final String verifiedCol = "verified";
    public static final String newsletterCol = "newsletter";
}
