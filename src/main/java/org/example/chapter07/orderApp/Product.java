package org.example.chapter07.orderApp;

public class Product {
    private String name;
    private int  price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    String getName() {
        return name;
    }
    int getPrice() {
        return price;
    }
    double calculateTax() {
        return price * 0.1;
    }
}
