package org.example.chapter06;

class Book{
   String title;
   String author;
   int year;

   Book(String title) {
       this(title, "Unknown Author");
   }
   Book(String title, String author) {
       this(title, author,-1);

   }
   Book(String title, String author, int year) {
       this.title = title;
       this.author = author;
       this.year = year;
   }
    public void printInfo() {
        System.out.println("제목: " + title + ", " + "저자: " + author + ", " + "출판년도: " + year);
    }
}
public class Y_Practice_Constructor {
    public static void main(String[] args) {
        Book book1 = new Book("데미안");
        Book book2 = new Book("어린왕자", "생텍쥐페리");
        Book book3 = new Book("1984", "조지 오웰", 1949);

        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
