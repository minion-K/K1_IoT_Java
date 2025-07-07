package org.example.chapter06;

class Stu{
    String name;
    int studentId;
    double grade;

    Stu() {
        name = "Unkown";
        studentId = 0;
        grade = 0.0;
    }
    Stu(String name, int studentId, double grade) {
        this.name = name;
        this. studentId = studentId;
        this.grade = grade;
    }
    void displayInfo() {
        System.out.println("Name:" + name + ", " + "ID: " + studentId + ", " + "Grade: " + grade);
    }
}
public class X_Practice {
    public static void main(String[] args) {
        Stu stu1 = new Stu();
        Stu stu2 = new Stu("홍길동", 12345, 4.2);

        stu1.displayInfo();
        stu2.displayInfo();
    }
}
