package org.example.Test0710.자바OOP구현문제;


abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }
    @Override
    double getArea() {
        return radius * radius * Math.PI;
    }
}
class Rectangle extends Shape {
    int a, b;

    Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    double getArea() {
        return a * b;
    }
}
public class Q3 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        System.out.println(circle.getArea());

        Shape rectangle = new Rectangle(8,3);
        System.out.println(rectangle.getArea());
    }
}
