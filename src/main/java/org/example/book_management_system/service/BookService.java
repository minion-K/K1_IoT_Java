package org.example.book_management_system.service;

import org.example.book_management_system.model.Book;

import java.util.List;

public interface BookService {
//    책 추가
    void addBook(Book book);

//    전체 책 조회
    List<Book> getAllBooks();
    
//    단건 조회
    // id
    Book getBookById(int id);
    // 제목
    List<Book> getBookByTitle(String title);

//    책 수정
    void updatedBook(int id, String newTitle);

//    저자 수정
    void updatedAuthor(int id, String newAuthor);
    
//    책 삭제
    void deletedBook(int id);
}
