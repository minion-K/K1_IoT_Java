package org.example.chapter07.orderApp;

public class Food extends Product{

    Food(String name, int price) {
        super(name, price);
    }

    @Override
    double calculateTax() {
        return 0;
    }
}
