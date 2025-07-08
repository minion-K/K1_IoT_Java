package org.example.chapter07.orderApp;

public class Electronics extends Product{

    Electronics(String name, int price){
        super(name, price);
    }
    @Override
    double calculateTax() {
        return getPrice() * 0.15;

    }
}
