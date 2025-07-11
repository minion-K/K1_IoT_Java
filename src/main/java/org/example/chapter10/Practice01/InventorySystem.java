package org.example.chapter10.Practice01;

import java.util.NoSuchElementException;
import java.util.Scanner;

// Inventory: 재고 관리
public class InventorySystem {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager(); // 도서 관리 시스템 인스턴스화
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println(" === Inventory System ===");
            System.out.println("1. Create 책 추가");
            System.out.println("2. Read 전체 책 조회");
            System.out.println("3. Update 책 수정(재고)");
            System.out.println("4. Delete 책 삭제");

            try {
//                sc.nextLine(); - 입력값이 문자열로 인식
                
//                Integer.parseInt(A)
//                : A 값을 분석하여 Integer 형태로 변경
//                - 숫자 형태로 변경할 수 없는 값이 입력되는 경우
//                      NumberFormatException 발생

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
//                        책 추가
                        System.out.print("Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = sc.nextLine();
                        System.out.print("Enter Book Publisher: ");
                        String publisher = sc.nextLine();
                        System.out.print("Enter Book Categoty: ");
                        String category = sc.nextLine();

                        System.out.print("Enter Book Publish Year: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Book Publish Price: " );
                        int price = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Book Publish Stock: ");
                        int stock = Integer.parseInt(sc.nextLine());

                        manager.add(new Book(id, title, isbn, author, publisher, year, price, stock, category));
                        break;
                    case 2:
                        manager.listAll();
                        break;
                    case 3:
                        System.out.print("Enter Book ID to update stock: ");
                        String updateId = sc.nextLine();
                        System.out.print("Enter Quantity to add/subtract: ");
                        int quantity = Integer.parseInt(sc.nextLine());

                        manager.updateStock(updateId, quantity);
                        break;
                    case 4:
                        System.out.print("Enter Book ID to remove: ");
                        String removedId = sc.nextLine();
                        manager.remove(removedId);
                        break;
                }

            } catch (NumberFormatException e) {
//                숫자 형태가 입력이 아닌 경우 발생
                System.out.println("Please Enter a valid number");
            } catch (NoSuchElementException e) {
//                컬렉션에서 요소를 가져올 때 해당 요소가 없는 경우 발생하는 예외
//                - 존재하지 않는 것을 가져올 때 발생
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            } 
        }
    }
}
