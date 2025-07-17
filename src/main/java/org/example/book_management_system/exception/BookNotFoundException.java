package org.example.book_management_system.exception;

import org.w3c.dom.ls.LSOutput;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) { super(message); }
}
