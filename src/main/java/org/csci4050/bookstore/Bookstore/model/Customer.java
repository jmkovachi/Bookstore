package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Customer extends User {
    private String firstName;
    private String minit;
    private String lastName;
    private String address;
    private Date birthDate;
    private Boolean verified;
    private Boolean newsletter;

    public static final String FIRST_NAME_COL = "first_name";
    public static final String MINIT_COL = "minit";
    public static final String LAST_NAME_COL = "last_name";
    public static final String ADDRESS_COL = "address";
    public static final String BIRTH_DATE_COL = "birth_date";
    public static final String VERIFIED_COL = "verified";
    public static final String NEWSLETTER_COL = "newsletter";
}
