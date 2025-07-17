package org.example.book_management_system.service;

import org.example.book_management_system.exception.BookNotFoundException;
import org.example.book_management_system.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements  BookService{

    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        try {
            Book existBook = getBookById(book.getId());
            throw new IllegalArgumentException("이미 존재하는 ID의 책입니다. - " + book.getId());

        } catch (BookNotFoundException e) {
            books.add(book);
        }

    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getBookById(int id) {
        for(Book book: books) {
            if(book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("해당 ID의 책이 없습니다. - " + id);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        List<Book> result = new ArrayList<>();

        for(Book book: books){
            if(book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        if(result.isEmpty()) {
            System.out.println("해당 제목의 책이 없습니다. - " + title);
        }
        return result;
    }

    @Override
    public void updatedBook(int id, String newTitle) {
        boolean found = false;

        for(Book book: books) {
            if(book.getId() == id) {
                book.setTitle(newTitle);
                found = true;
                break;
            }
        }
        if(!found){
            throw new BookNotFoundException("해당 ID의 책이 없습니다. - " + id);
        }
    }

    @Override
    public void updatedAuthor(int id, String newAuthor) {
        boolean found = false;

        for(Book book: books) {
            if(book.getId() == id) {
                book.setAuthor(newAuthor);
                found = true;
                break;
            }
        }
        if(!found){
            throw new BookNotFoundException("해당 ID의 책이 없습니다. - " + id);
        }
    }

    @Override
    public void deletedBook(int id) {
        boolean found = false;

        for(Book book: books) {
            if(book.getId() == id) {
                books.remove(getBookById(id));
                found = true;
                break;
            }
        }
        if(!found) {
            throw new BookNotFoundException("해당 ID의 책이 없습니다. - " + id);
        }
    }
}
