package org.example.book_management_system;

import org.example.book_management_system.exception.BookNotFoundException;
import org.example.book_management_system.model.Book;
import org.example.book_management_system.service.BookService;
import org.example.book_management_system.service.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        Scanner sc = new Scanner(System.in);

        bookService.addBook(new Book(1, "조종당하는 인간", "김석재"));
        bookService.addBook(new Book(2, "혼모노", "성해나"));
        bookService.addBook(new Book(3, "안녕이라 그랬어", "김애란"));
        bookService.addBook(new Book(4, "류수영의 평생 레시피", "류수영"));
        bookService.addBook(new Book(5, "결국 마음먹은 대로 된다", "나폴레온 힐"));
        bookService.addBook(new Book(6, "료의 생각 없는 생강", "료"));
        bookService.addBook(new Book(7, "안녕하십니까", "권민현"));

//        for(Book book: bookService.getAllBooks()){
//            System.out.println(book);
//        }
        while(true) {
            System.out.println("===================== Book Management System =====================");
            System.out.println("1. 책 추가");
            System.out.println("2. 책 전체 검색");
            System.out.println("3. 책 ID로 검색");
            System.out.println("4. 책 제목으로 검색");
            System.out.println("5. 책 수정");
            System.out.println("6. 저자 수정");
            System.out.println("7. 책 삭제");
            System.out.println("0. 프로그램 종료");
            System.out.println("==================================================================");


            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    try{
                        System.out.print("책 ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("책 이름: ");
                        String title = sc.nextLine();
                        System.out.print("저자: ");
                        String author = sc.nextLine();
                        bookService.addBook(new Book(id, title, author));
                        System.out.println("책 추가가 완료되었습니다.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 2: {
                    System.out.println("=== 전체 책 목록 ===");
                    List<Book> bookList = bookService.getAllBooks();
                    for (Book book : bookList) {
                        System.out.println(book);
                    }
                    break;
                }

                case 3: {
                    try {
                        System.out.print("검색할 책 ID 입력: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        Book book = bookService.getBookById(id);
                        System.out.println(book);
                    } catch (BookNotFoundException e) {
                        System.out.println("조회 실패: " + e.getMessage());
                    }
                    break;
                }

                case 4: {
                    try {
                        System.out.print("검색할 책 제목 입력: ");
                        String title = sc.nextLine();
                        List<Book> bookList = bookService.getBookByTitle(title);
                        for (Book book : bookList) {
                            System.out.println(book);
                        }
                    } catch (BookNotFoundException e) {
                        System.out.println("조회 실패: " + e.getMessage());
                    }
                    break;
                }

                case 5: {
                    try {
                        System.out.print("수정할 책 ID 입력: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("새로운 책 이름 입력: ");
                        String title = sc.nextLine();
                        bookService.updatedBook(id, title);
                        System.out.println("책 수정이 완료되었습니댜.");
                    } catch (BookNotFoundException e) {
                        System.out.println("수정 실패: " + e.getMessage());
                    }
                    break;
                }

                case 6: {
                    try {
                        System.out.print("수정할 책 ID 입력: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("새로운 저자 이름 입력: ");
                        String title = sc.nextLine();
                        bookService.updatedAuthor(id, title);
                        System.out.println("저자 수정이 완료되었습니댜.");
                    } catch (BookNotFoundException e) {
                        System.out.println("수정 실패: " + e.getMessage());
                    }
                    break;
                }

                case 7: {
                    try {
                        System.out.print("삭제할 책 ID 입력: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        bookService.deletedBook(id);
                        System.out.println("책 삭제가 완료되었습니다. ");
                    } catch (BookNotFoundException e) {
                        System.out.println("조회 실패: " + e.getMessage());
                    }
                    break;
                }


                case 0: {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
            }
        }
    }
}
