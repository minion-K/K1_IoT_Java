package org.example.Test0710.자바OOP구현문제;


class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String getName() {
        return this.name;
    }
    int getAge() {
        return this.age;
    }
    void setName(String name) {
        this.name = name;
    }
    void setAge(int age) {
        if(age < 0 ) {
            System.out.println("나이를 잘못 입력하였습니다.");
        }
        this.age = age;
    }

}


public class Q2 {
    public static void main(String[] args) {
        Person person = new Person("권민현", 31);

        System.out.println(person.getName());
        System.out.println(person.getAge());

        person.setName("민현");
        person.setAge(28);

        System.out.println(person.getName());
        System.out.println(person.getAge());

        person.setAge(-10);

    }


}
