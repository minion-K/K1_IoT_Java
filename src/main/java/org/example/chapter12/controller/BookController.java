package org.example.chapter12.controller;

import org.example.chapter12.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    //    실제 데이터들이 저장되는 리스트
    private List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
    }

    //    1. 책 추가(요청: 책 데이터 / 응답: X)
    public void addBook(String title, String author, String publisher) {
        Book newBook = new Book(title, author, publisher);
        books.add(newBook);
    }

    //    2. 전체 책 조회(요청: X / 응답: 책 데이터 리스트)
    public List<Book> getAllBooks() {
        return books;
    }

    //    3. 책 검색(책 제목)(요청: 검색어 / 응답: 검색 된 책 데이터 리스트)
    public List<Book> searchBook(String title) {
        List<Book> result = new ArrayList<>();

        for(Book book: books) {
            if(book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }

}
