package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Verification {
    private int verificationCode;
    private String cUserName;
    private String email;
}
