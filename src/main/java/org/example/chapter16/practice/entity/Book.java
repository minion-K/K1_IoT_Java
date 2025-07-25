package org.example.chapter16.practice.entity;

import lombok.Getter;

@Getter
public class Book extends Item{
    private String isbn; // 책 고유 값
    private String author;
    private String publisher;
//    private int publisherYear;
//    private int price;
//    private int stock;
    private Category category;

    public Book(String id, String name, String isbn, String author, String publisher, Category category) {
        super(id, name);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    @Override
    public void display() {
        System.out.println("ID: " + getId() + ", Title: " + getName() + ", Category: " + category);
    }
}
