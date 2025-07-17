package org.example.book_management_system.model;

import org.example.book_management_system.util.DateUtil;

public class Book {
    private int id;
    private String title;
    private String author;
    private String createdAt;
    private String updatedAt;



    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = DateUtil.now();
        this.updatedAt = DateUtil.now();
    }
    public int getId() { return id;}
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCreatedAt() { return createdAt; }
    public String getUpdatedUtil() { return updatedAt; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) {
        this.author = author;
        this.updatedAt= DateUtil.now();
    }

    @Override
    public String toString() {
        return "[ ID: " + id
                + ", 책 이름: " + title
                + ", 저자: " + author
                + ", 생성일: " + createdAt
                + ", 수정일: " + updatedAt + " ]";
    }
}
