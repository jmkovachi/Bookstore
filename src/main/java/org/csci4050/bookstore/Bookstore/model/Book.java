package org.csci4050.bookstore.Bookstore.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Book {
    private String isbn;
    private String title;
    private Date datePublished;
    private String author;
    private String category;
    private Double price;
    private Integer totalInventory;
    private Integer promoId;
    private String imageUrl;
    private Float rating;
    private String summary;
    private Integer pages;
    private String vUsername;
}
